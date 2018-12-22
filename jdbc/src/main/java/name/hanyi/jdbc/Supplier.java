package name.hanyi.jdbc;

import java.sql.Connection;
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
}
