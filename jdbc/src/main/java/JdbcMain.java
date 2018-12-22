import name.hanyi.jdbc.HDataSource;
import name.hanyi.jdbc.JdbcContext;

public class JdbcMain {
    public static void main(String[] args) {
        HDataSource ds = new HDataSource("test", "test", "test");
        JdbcContext context = new JdbcContext();
        context.setDataSource(ds);
        context.run();
    }
}
