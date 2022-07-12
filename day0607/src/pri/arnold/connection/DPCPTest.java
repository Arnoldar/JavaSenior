package pri.arnold.connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: Arnold
 * @Date: 2022/7/8 18:30
 */
public class DPCPTest {

    @Test
    public void test() throws Exception {
        BasicDataSource source = new BasicDataSource();

        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8");
        source.setUsername("root");
        source.setPassword("123456");
        Connection conn = source.getConnection();
        System.out.println(conn);

    }


    @Test
    public void test1() throws Exception {

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dpcp.properties");

        Properties pros = new Properties();
        pros.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn);

    }



}
