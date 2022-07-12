package pri.arnold1.dao;

import org.apache.commons.dbutils.DbUtils;
import org.junit.jupiter.api.Test;
import pri.arnold1.bean.Customer;
import pri.arnold1.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOImplTest {
    private CustomerDAOImpl cdi = new CustomerDAOImpl();

    @Test
    void insert() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Date date = new Date(12313213L);
            Customer cust1 = new Customer("陈奕迅", "jak@eamisa.com", date);
            cdi.insert(conn,cust1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    @Test
    void deleteById() throws Exception {
    }

    @Test
    void update() {
    }

    @Test
    void getCustomerById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Customer customerById = cdi.getCustomerById(conn, 1);
            System.out.println(customerById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    @Test
    void getAll() {
    }

    @Test
    void getCount() {

    }

    @Test
    void getMaxBirth() {
    }
}