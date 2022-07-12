package pri.arnold.preparedstatement;

import org.junit.Test;
import pri.arnold.utils.JDBCUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author: Arnold
 * @Date: 2022/7/7 10:50
 */
public class TestForBlob {


    @Test
    public void test() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into customers(photo) values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        FileInputStream fis = new FileInputStream(new File("D:\\JavaSenior\\day0607\\src\\timg.jpg"));
        ps.setBlob(1,fis);
        ps.execute();
        JDBCUtils.closeResource(conn,ps);
        fis.close();
    }

    @Test
    public void test1() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select photo from customers where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,16);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Blob blob = rs.getBlob(1);
        InputStream bs = blob.getBinaryStream();
        FileOutputStream fos = new FileOutputStream(new File("wuming.jpg"));
        byte[] bytes = new byte[1024];
        int len;
        if ((len = bs.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        JDBCUtils.closeResource(conn,ps,rs);

        fos.close();
        bs.close();

    }


}
