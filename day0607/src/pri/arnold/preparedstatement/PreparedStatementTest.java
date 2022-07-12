package pri.arnold.preparedstatement;

import org.junit.Test;
import pri.arnold.utils.JDBCUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
//import pri.arnold.utils.*;

/**
 * @Author: Arnold
 * @Date: 2022/6/7 11:55
 */
public class PreparedStatementTest {


    @Test
    public void test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2022-06-08");

        update("update customers set name=? where id=?","齐天大圣",19);
    }


    public void update(String sql, Object... parms) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < parms.length; i++) {
                ps.setObject(i + 1, parms[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }


    @Test
    public void testDelete() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from customers where id=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 20);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }


    @Test
    public void testUpdata() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "孙悟空");
            ps.setObject(2, 19);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }


    @Test
    public void testInsert1() {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into customers(name,email,birth) values(?,?,?)";//?:占位符
            ps = conn.prepareStatement(sql);
            //5.填充占位符
            ps.setString(1, "哪吒");
            ps.setString(2, "nezha@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1000-01-01");
            ps.setDate(3, new java.sql.Date(date.getTime()));
            //6.执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }

    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.读取配置文件中的4个基本信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

            Properties pros = new Properties();
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");
            //3.加载驱动
            Class.forName(driverClass);
            //3.获取连接
            conn = DriverManager.getConnection(url, user, password);
//            System.out.println(conn);
            //4.预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into customers(name,email,birth) values(?,?,?)";//?:占位符
            ps = conn.prepareStatement(sql);
            //5.填充占位符
            ps.setString(1, "哪吒");
            ps.setString(2, "nezha@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1000-01-01");
            ps.setDate(3, new java.sql.Date(date.getTime()));
            //6.执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.资源关闭
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
}
