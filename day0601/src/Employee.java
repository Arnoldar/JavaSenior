import java.util.Objects;

/**
 * @Author: Arnold
 * @Date: 2022/6/1 11:57
 */
public class Employee{

    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthady() {
        return birthday;
    }

    public void setBirthady(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Employee){
//            Employee e = (Employee)o;
//            return this.getName().compareTo(e.getName());
//        }
//        return 0;
//    }
}
