package name.hanyi.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Coffee {

    private final HDataSource ds;

    public Coffee(HDataSource ds) {
        this.ds = ds;
    }

    public void viewAll() {
        Connection conn = ds.getConnection();
        try (Statement st = conn.createStatement()) {
            String statement = "select COF_NAME from COFFEES";
            ResultSet rs = st.executeQuery(statement);
            while (rs.next()) {
                String coffeeName = rs.getString("COF_NAME");
                System.out.println("coffeeName: " + coffeeName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("db execute error");
        }
    }
}
