package pri.arnold.io;

import org.junit.Test;

import java.io.*;

/**
 * @Author: Arnold
 * @Date: 2022/6/13 16:45
 */
public class BufferTest {

    @Test
    public void test() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File f1 = new File("gaoxiaoxiaoxiaoxiao.txt");
            File f2 = new File("bugaoxiaoxiaoxiaoxiaoxiao.txt");
            FileReader fr = new FileReader(f1);
            FileWriter fw = new FileWriter(f2);

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            String cBuf;
            while ((cBuf = br.readLine()) != null) {
                bw.write(cBuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
