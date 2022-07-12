package pri.arnold.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Arnold
 * @Date: 2022/6/10 16:14
 */

public class FileTest1 {
    private int count = 0;


    @Test
    public void test3() throws IOException {
        File file = new File("D:\\JavaSenior\\day0609\\file1\\a.txt");
//        file.createNewFile();
        File file1 = new File(file.getParent(), "b.txt");
        file1.createNewFile();

    }

    @Test
    public void test(){
        File file = new File("D:\\JavaSenior\\day0609\\file1");
        searchFileName(file);
        System.out.println(count);
        deleteFile(file);
        searchFileName(file);
    }

    public void searchFileName(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                count += f.length();
                System.out.println(f.getAbsolutePath());
            } else {
                searchFileName(f);
            }
        }
    }

    public void deleteFile(File file){
        File[] files = file.listFiles();
        for (File file1 : files){
            if (file1.isFile()){
                file1.delete();
            }else {
                if (file1.listFiles() == null){
                    file1.delete();
                }else {
                    deleteFile(file1);
                    file1.delete();
                }
            }
        }
    }
}
