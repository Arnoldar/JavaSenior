package pri.arnold.connectin;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: Arnold
 * @Date: 2022/6/7 8:35
 */
public class ConnectionTest {

    @Test
    public void test4() throws Exception {
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);

        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    @Test
    public void test3() throws Exception {
//        Class clazz = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String password = "123456";
//        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test1() throws SQLException {

        Driver driver = new com.mysql.jdbc.Driver();


        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";

        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        Connection connect = driver.connect(url, info);

        System.out.println(connect);
    }

    @Test
    public void test2() throws SQLException, Exception {

        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();


        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";

        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        Connection connect = driver.connect(url, info);

        System.out.println(connect);
    }

}
