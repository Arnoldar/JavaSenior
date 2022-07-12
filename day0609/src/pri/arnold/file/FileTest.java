package pri.arnold.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Arnold
 * @Date: 2022/6/10 8:49
 */
public class FileTest {

    @Test
    public void test2() {
        File file = new File("D:\\JavaSenior\\day0609\\file1");
        long length = file.length();
        System.out.println(length);
    }


    @Test
    public void test1() {
        File file = new File("D:\\JavaSenior\\day0609");
        String[] list = file.list();
        boolean isFlag = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i].contains(".jpg")) {
                System.out.println(list[i].toString());
                isFlag = true;
            }
        }
        if (isFlag == false) {
            System.out.println("暂未发现文件");
        }
    }


    @Test
    public void test() {
        try {
            addCataLogue("D:\\JavaSenior\\day0609\\file1", "D:\\JavaSenior\\day0609\\file2",
                    "D:\\JavaSenior\\day0609\\file3");
            addFile("D:\\JavaSenior\\day0609\\hello.txt", "D:\\JavaSenior\\day0609\\hxt.txt",
                    "D:\\JavaSenior\\day0609\\h.txt");
            deleteFile("D:\\JavaSenior\\day0609\\hxt.txt", "D:\\JavaSenior\\day0609\\h.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addFile(String... args) throws IOException {
        for (int i = 0; i < args.length; i++) {
            File file = new File(args[i]);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("创建成功");
            } else {
                System.out.println("已存在");
            }
        }
    }

    public void addCataLogue(String... args) throws IOException {
        for (int i = 0; i < args.length; i++) {
            File file = new File(args[i]);
            boolean mkdirs = file.mkdirs();
            if (mkdirs) {
                System.out.println("创建成功");
            } else {
                System.out.println("创建失败");
            }
        }
    }

    public void deleteFile(String... args) throws IOException {
        for (int i = 0; i < args.length; i++) {
            File file = new File(args[i]);
            if (file.exists()) {
                file.delete();
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }
    }


}
