import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @Author: Arnold
 * @Date: 2022/6/6 11:32
 */
public class Exer2 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Student && o2 instanceof Student){
                    Student s1 = (Student)o1;
                    Student s2 = (Student)o2;
                    return -Double.compare(s1.getScore(),s2.getScore());
                }
                throw new RuntimeException("类型不一致");
            }
        });
        set.add(new Student("Tom",95,1));
        set.add(new Student("Jame",50,2));
        set.add(new Student("Simth",100,3));
        System.out.println(set);
    }
}
