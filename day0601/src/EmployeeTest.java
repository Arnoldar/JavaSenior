import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author: Arnold
 * @Date: 2022/6/1 12:02
 */
public class EmployeeTest {
    public static void main(String[] args) {

        TreeSet employ = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee)o1;
                    Employee e2 = (Employee)o2;
                    int mnusYear = e1.getBirthady().getYear() - e2.getBirthady().getYear();
                    if (mnusYear != 0){
                        return mnusYear;
                    }
                    int mnusMonth = e1.getBirthady().getMonth() - e2.getBirthady().getMonth();
                    if (mnusMonth != 0){
                        return mnusMonth;
                    }
                    int mnusDay = e1.getBirthady().getDay() - e2.getBirthady().getDay();
                    if (mnusDay != 0){
                        return mnusDay;
                    }
                }
                return 0;
            }
        });

        employ.add(new Employee("Tom",21,new MyDate(2021,2,3)));
        employ.add(new Employee("James",25,new MyDate(2000,4,5)));
        employ.add(new Employee("Cobe",45,new MyDate(2000,4,12)));
        employ.add(new Employee("Aurry",19,new MyDate(1870,2,31)));
        employ.add(new Employee("Bluth",20,new MyDate(2001,12,20)));


        Iterator iterator = employ.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
