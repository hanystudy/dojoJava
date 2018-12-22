package name.hanyi.jdbc;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HDataSource {

    private Connection conn;
    private JdbcDataSource ds;

    public HDataSource(String dbName, String user, String password) {
        try {
            ds = new JdbcDataSource();
            ds.setURL("jdbc:h2:mem:" + dbName);
            ds.setUser(user);
            ds.setPassword(password);
            conn = ds.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException("init db error");
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
