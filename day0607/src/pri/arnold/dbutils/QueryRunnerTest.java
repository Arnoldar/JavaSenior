package pri.arnold.dbutils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import pri.arnold.bean.Customer;
import pri.arnold.connection.DruidTest;
import pri.arnold.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Arnold
 * @Date: 2022/7/9 7:31
 */
public class QueryRunnerTest {

    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = DruidTest.getConnection();
            String sql = "insert into customers(name,email,birth) values(?,?,?)";
            int insertCount = runner.update(conn, sql, "蔡徐坤", "caixukun@123.com", "1997-09-08");
            System.out.println("添加了几条记录" + insertCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void testQuery1() {

        Connection conn = null;
        try {
            conn = DruidTest.getConnection();
            QueryRunner runner = new QueryRunner();
            String sql = "select id,name,email,birth from customers";
            BeanListHandler<Customer> handler = new BeanListHandler<Customer>(Customer.class);
            List<Customer> customers = runner.query(conn, sql, handler);
            customers.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

    }



    @Test
    public void testQuery2(){
        Connection conn = null;
        try {
            conn = DruidTest.getConnection();
            QueryRunner runner = new QueryRunner();
            String sql = "select id,name,email,birth from customers where id=?";
            BeanHandler<Customer> handler = new BeanHandler<Customer>(Customer.class);
            Customer customer = runner.query(conn, sql, handler, 24);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void testQuery3(){
        Connection conn = null;
        try {
            conn = DruidTest.getConnection();
            QueryRunner runner = new QueryRunner();
            String sql = "select count(*) from customers";
            ScalarHandler handler = new ScalarHandler();
            long query = (long) runner.query(conn, sql, handler);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }

    @Test
    public void testQuery4(){
        Connection conn = null;
        try {
            conn = DruidTest.getConnection();
            QueryRunner runner = new QueryRunner();
            String sql = "select max(birth) from customers";
            ScalarHandler handler = new ScalarHandler();
            Date query = (Date) runner.query(conn, sql, handler);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
