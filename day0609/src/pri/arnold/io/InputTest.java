package pri.arnold.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @Author: Arnold
 * @Date: 2022/6/14 11:06
 */
public class InputTest {

    @Test
    public void test1() {
        BufferedReader br = null;
        try {

            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    break;
                }
                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void test() {
        Scanner scanner = new Scanner(System.in);
        boolean isFlag = true;
        while (isFlag) {
            System.out.print("请输入字符串：");
            String i = scanner.next();
            if (i.equals("e") || i.equals("exit")) {
                isFlag = false;
            } else {
                System.out.println(i.toUpperCase());
            }
        }
    }
}
