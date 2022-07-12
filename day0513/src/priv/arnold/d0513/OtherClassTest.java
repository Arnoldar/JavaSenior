package priv.arnold.d0513;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Arnold
 * @Date: 2022/5/13 19:21
 */
public class OtherClassTest {

    @Test
    public void test1() throws ParseException {
        String str = "2017-08-16";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(str);
        java.sql.Date sd = new java.sql.Date(d1.getTime());
        System.out.println(sd);
    }


    @Test
    public void test(){
        String property = System.getProperty("os.version");
        System.out.println(property);
    }
}
