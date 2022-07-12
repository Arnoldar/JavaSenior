package pri.arnold.preparedstatement;

import org.junit.Test;
import pri.arnold.bean.Customer;
import pri.arnold.bean.Order;
import pri.arnold.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Arnold
 * @Date: 2022/6/8 14:44
 */
public class CustomerForQuery {

    @Test
    public void test6(){
        CustomerForQuery cfq = new CustomerForQuery();
        String sql1 = "SELECT order_id orderId,order_name orderName,order_date orderDate FROM `order`";
        String sql2 = "select id,name,email,birth from customers";

        List<Order> orders = cfq.queryForAll(Order.class, sql1);
        orders.forEach(System.out::println);

        List<Customer> customers = cfq.queryForAll(Customer.class, sql2);
        customers.forEach(System.out::println);
    }



    public <T> List<T> queryForAll(Class<T> clazz,String sql,Object ... obj) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);

            for (int i = 0;i < obj.length;i++){
                ps.setObject(i + 1,obj[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<T> ts = new ArrayList<T>();

            while (rs.next()){

                T t = clazz.newInstance();

                for (int i = 0;i < columnCount;i++){
                    Object object = rs.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,object);
                }
                ts.add(t);
            }
            return ts;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }




//    @Test
//    public void test6(){
//        CustomerForQuery cfq = new CustomerForQuery();
//        String table1 = "pri.arnold.bean.Order";
//        String table2 = "pri.arnold.bean.Customer";
//        String sql1 = "SELECT order_id orderId,order_name orderName,order_date orderDate FROM `order`";
//        String sql2 = "select id,name,email,birth from customers";
//        ArrayList objects = cfq.queryForAll(table1, sql1);
//        for (Object o1 : objects){
//            System.out.println(o1);
//        }
//        ArrayList objects1 = cfq.queryForAll(table2, sql2);
//        for (Object o2 : objects1){
//            System.out.println(o2);
//        }
//
//    }
//
//
//
//    public ArrayList queryForAll(String tableName, String sql, Object ... obj) {
//
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            conn = JDBCUtils.getConnection();
//
//            ps = conn.prepareStatement(sql);
//
//            ArrayList<Object> objects = new ArrayList<>();
//
//            for (int i = 0;i < obj.length;i++){
//                ps.setObject(i + 1,obj[i]);
//            }
//
//            rs = ps.executeQuery();
//            ResultSetMetaData metaData = rs.getMetaData();
//            int columnCount = metaData.getColumnCount();
//
//            while (rs.next()){
//                Class aClass = Class.forName(tableName);
//                Object o = aClass.newInstance();
//                for (int i = 0;i < columnCount;i++){
//                    Object object = rs.getObject(i + 1);
//                    String columnLabel = metaData.getColumnLabel(i + 1);
//                    Field field = aClass.getDeclaredField(columnLabel);
//                    field.setAccessible(true);
//                    field.set(o,object);
//                }
//                objects.add(o);
//            }
//            return objects;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            JDBCUtils.closeResource(conn,ps,rs);
//        }
//        return null;
//    }


    @Test
    public void test5(){
        CustomerForQuery cfq = new CustomerForQuery();
        String sql = "SELECT order_id orderId,order_name orderName,order_date orderDate FROM `order`";
        ArrayList<Order> orders = cfq.queryForOrder(sql);
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    public ArrayList<Order> queryForOrder(String sql,Object ... obj){

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ArrayList<Order> orders = new ArrayList<>();

            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);

            for (int i = 0;i < obj.length;i++){
                ps.setObject(i + 1,obj[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()){
                Order order = new Order();
                for (int i = 0;i < columnCount;i++){
                    Object object = rs.getObject(i + 1);
                    String columnName = metaData.getColumnLabel(i + 1);
                    Field field = Order.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(order,object);
                }
                orders.add(order);
            }
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }







    @Test
    public void test2(){
        CustomerForQuery cfq = new CustomerForQuery();
        String sql = "select id,name,email,birth from customers";
        ArrayList al = cfq.queryForCustomers(sql);
        for (Object obj : al){
            System.out.println(al);
        }

    }

    public ArrayList queryForCustomers(String sql, Object ... obj){
        ArrayList al = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);

            for (int i = 0;i < obj.length;i++){
                ps.setObject(i + 1,obj[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()){
                Class<? extends PreparedStatement> aClass = ps.getClass();
                Object instance = aClass.newInstance();
                for (int i = 0;i < columnCount;i++){
                    String columnName = metaData.getColumnName(i + 1);
                    Object object = rs.getObject(i + 1);
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(instance,object);
                }
                al.add(instance);
            }
            return al;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }




    public List select(String sql, Object ... objects){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List customerss = new ArrayList();
        try {
            conn = JDBCUtils.getConnection();
//            String sql = "select id,name,email,birth from customers where id=?";
            ps = conn.prepareStatement(sql);
            for (int i = 0;i < objects.length;i++){
                ps.setObject(i + 1, objects[i]);
            }
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date date = resultSet.getDate(4);
                Customer customer = new Customer(id, name, email, date);
                customerss.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, resultSet);
            return customerss;
        }
    }

    @Test
    public void test1(){
        List select = select("select id,name,email,birth from customers where id=?",2);
        Iterator iterator = select.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }



    @Test
    public void test() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth from customers where id=?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 1);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date date = resultSet.getDate(4);
                Customer customer = new Customer(id, name, email, date);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
    }
}
