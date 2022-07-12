import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: Arnold
 * @Date: 2022/6/6 10:32
 */
public class Exer1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入10个整数：");
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            int i1 = scanner.nextInt();
            list.add(i1);
        }
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    Integer i1 = (Integer) o1;
                    Integer i2 = (Integer) o2;
                    return -Integer.compare(i1, i2);
                }
                throw new RuntimeException("输入的类型不一致");
            }
        });
        System.out.println(list);
    }
}
