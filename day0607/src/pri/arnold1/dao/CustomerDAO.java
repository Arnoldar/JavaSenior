package pri.arnold1.dao;

import pri.arnold1.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @Author: Arnold
 * @Date: 2022/7/11 10:03
 */
public interface CustomerDAO {

    void insert(Connection conn,Customer cust);
    void deleteById(Connection conn,int id);
    void update(Connection conn,Customer cust);
    Customer getCustomerById(Connection conn,int id);
    List<Customer> getAll(Connection conn);
    long getCount(Connection conn);
    Date getMaxBirth(Connection conn);

}
