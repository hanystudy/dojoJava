package name.hanyi.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcContext {
    private HDataSource ds;

    public void setDataSource(HDataSource ds) {
        this.ds = ds;
    }

    public void run() {
        initDatabase();
        Coffee coffee = new Coffee(ds);
        coffee.viewAll();
        coffee.modifyPrices(0.5F);
        Supplier supplier = new Supplier(ds);
        supplier.addNewSuppliers();
        supplier.viewAll();
    }

    private void initDatabase() {
        Path path = getSchemaScript();
        String line;
        Connection conn = ds.getConnection();
        StringBuffer content = new StringBuffer();
        try (BufferedReader reader = Files.newBufferedReader(path);
             Statement st = conn.createStatement()) {
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            conn.setAutoCommit(false);
            String[] statements = content.toString().split(";");
            for (String statement : statements) {
                if (!statement.trim().isEmpty()) {
                    st.addBatch(statement);
                    System.out.println(">>" + statement);
                }
            }
            st.executeBatch();
            conn.commit();
        } catch (IOException |SQLException ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("db execute error");
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException("db execute error");
            }
        }
    }

    private Path getSchemaScript() {
        URL resourceUrl = getClass().getClassLoader().getResource("schema.sql");
        Path path;
        try {
            path = Paths.get(resourceUrl.toURI());

        } catch (URISyntaxException ex) {
            throw new RuntimeException("url error");
        }
        return path;
    }
}
