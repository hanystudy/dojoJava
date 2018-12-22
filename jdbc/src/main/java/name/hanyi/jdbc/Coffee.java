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

    public void modifyPrices(float percentage) {
        Connection conn = ds.getConnection();
        try (Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            String statement = "select COF_NAME, PRICE from COFFEES";
            ResultSet rs = st.executeQuery(statement);
            while (rs.next()) {
                String coffeeName = rs.getString("COF_NAME");
                float price = rs.getFloat("PRICE");
                System.out.format("coffeeName: %s, price: %f\n", coffeeName, price);
                rs.updateFloat("PRICE", price * percentage);
                rs.updateRow();
                rs.refreshRow();
                System.out.format("coffeeName: %s, discounted price: %f\n", coffeeName, rs.getFloat("PRICE"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("db execute error");
        }
    }
}
