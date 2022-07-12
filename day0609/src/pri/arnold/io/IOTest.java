package pri.arnold.io;

import org.junit.Test;

import java.io.*;

/**
 * @Author: Arnold
 * @Date: 2022/6/13 14:21
 */
public class IOTest {

    @Test
    public void test2() {

        FileInputStream fis = null;
        try {
            File file = new File("timg.jpg");

            fis = new FileInputStream(file);

            int len;
            while ((len = fis.read()) != -1){
                System.out.print(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    @Test
    public void test1() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File f1 = new File("timg.jpg");
            File f2 = new File("timg1.jpg");

            fis = new FileInputStream(f1);
            fos = new FileOutputStream(f2);

            int len;
            byte[] cBuf = new byte[5];
            while ((len = fis.read(cBuf)) != -1) {
                fos.write(cBuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File f1 = new File("hehe.txt");
            File f2 = new File("haha.txt");
            fr = new FileReader(f1);
            fw = new FileWriter(f2);

            int len;
            char[] readContent = new char[5];
            while ((len = fr.read(readContent)) != -1) {
                fw.write(readContent, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
