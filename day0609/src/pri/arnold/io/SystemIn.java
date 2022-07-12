package pri.arnold.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: Arnold
 * @Date: 2022/6/14 13:57
 */
public class SystemIn {

    public String getString () throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String s = br.readLine();
        return s;

    }

    @Test
    public void test(){
        File file = new File("haha.txt");
        File file1 = new File("hehe.txt");
        try {
            FileUtils.copyFile(file,file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
