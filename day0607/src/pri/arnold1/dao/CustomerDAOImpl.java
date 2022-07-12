package pri.arnold1.dao;

import pri.arnold1.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @Author: Arnold
 * @Date: 2022/7/11 10:24
 */
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {
    @Override
    public void insert(Connection conn, Customer cust) {
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getDate());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id=?";
        update(conn,sql,id);
    }

    @Override
    public void update(Connection conn, Customer cust) {
        String sql = "update customers set name=?,email=?,birth=? where id=?";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getDate(),cust.getId());
    }

    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select name,email,birth from customers where id=?";
        Customer instance = getInstance(conn, Customer.class, sql, id);
        return instance;
    }

    @Override
    public List<Customer> getAll(Connection conn) {
        String sql = "select name,email,birth from customers";
        List<Customer> listFor = getListFor(conn, Customer.class, sql);
        return listFor;
    }

    @Override
    public long getCount(Connection conn) {
        String sql = "select count(*) from customers";
        Object value = getValue(conn, sql);
        return (long) value;
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select Max(birth) from customers";
        Object value = getValue(conn, sql);
        return (Date) value;
    }
}
