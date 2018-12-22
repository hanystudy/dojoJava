package name.hanyi.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Supplier {

    private final HDataSource ds;

    public Supplier(HDataSource ds) {
        this.ds = ds;
    }

    public void viewAll() {
        Connection conn = ds.getConnection();
        try (Statement st = conn.createStatement()) {
            String statement = "select SUP_NAME from SUPPLIERS";
            ResultSet rs = st.executeQuery(statement);
            while (rs.next()) {
                String coffeeName = rs.getString("SUP_NAME");
                System.out.println("supplierName: " + coffeeName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("db execute error");
        }
    }

    public void addNewSuppliers() {
        Connection conn = ds.getConnection();
        try (PreparedStatement st = conn.prepareStatement("insert into SUPPLIERS VALUES(?, ?, ?, ?, ?, ?)")) {
            conn.setAutoCommit(false);
            st.setInt(1, 1);
            st.setString(2, "Hand made Coffee");
            st.setString(3, "Locust ST");
            st.setString(4, "Philadelphia");
            st.setString(5, "PA");
            st.setString(6, "19104");
            st.addBatch();
            st.executeBatch();
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("db execute error");
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("db execute error");
            }
        }
    }
}
