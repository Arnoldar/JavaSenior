package pri.arnold.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;

/**
 * @Author: Arnold
 * @Date: 2022/7/8 15:26
 */
public class C3P0Test {

    @Test
    public void testGetConnection() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC" );
        cpds.setUser("root");
        cpds.setPassword("123456");
        cpds.setInitialPoolSize(10);

        Connection conn = cpds.getConnection();
        System.out.println(conn);

    }

    @Test
    public void testGetConnection1() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);

    }

}
