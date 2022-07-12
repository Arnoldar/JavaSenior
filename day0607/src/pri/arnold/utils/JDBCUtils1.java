package pri.arnold.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: Arnold
 * @Date: 2022/7/6 16:21
 */
public class JDBCUtils1 {

    public static Connection getConnection() throws Exception {
//        InputStream is = ClassLoader.getSystemResourceAsStream("jdbc.properties");
        File file = new File("D:\\JavaSenior\\day0607\\src\\jdbc.properties");
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
