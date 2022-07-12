/**
 * @Author: Arnold
 * @Date: 2022/6/6 11:35
 */
public class Student {

    private String name;
    private double score;
    private int id;

    public Student() {
    }

    public Student(String name, double score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id=" + id +
                '}';
    }
}
