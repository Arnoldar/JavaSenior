package pri.arnold.io;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Arnold
 * @Date: 2022/6/13 19:14
 */
public class ExerTwo {
    @Test
    public void test() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            HashMap<Character, Integer> hm = new HashMap<>();
            br = new BufferedReader(new FileReader(new File("gaoxiaoxiaoxiaoxiao.txt")));
            bw = new BufferedWriter(new FileWriter(new File("count.txt")));

            int len;
            while ((len = br.read()) != -1){
                char lens = (char)len;
                if (!hm.containsKey(lens)){
                    hm.put(lens,1);
                }else {
                    hm.put(lens,hm.get(lens) + 1);
                }
            }

            Set<Map.Entry<Character, Integer>> set = hm.entrySet();
            for (Map.Entry<Character,Integer> et : set){
                switch (et.getKey()){
                    case '\n':
                        bw.write("换行=" + et.getValue() + "\n");
                        break;
                    case '\t':
                        bw.write("tab键=" + et.getValue() + "\n");
                        break;
                    case '\r':
                        bw.write("回车=" + et.getValue() + "\n");
                        break;
                    case ' ':
                        bw.write("空格=" + et.getValue() + "\n");
                        break;
                    default:
                        bw.write(et.getKey() + "=" +et.getValue() + "\n");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
