package pri.arnold1.bean;


import java.sql.Date;

/**
 * @Author: Arnold
 * @Date: 2022/6/8 15:15
 */
public class Customer {

    private int id;
    private String name;
    private String email;
    private Date birth;

    public Customer(String name, String email, Date birth) {
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return birth;
    }

    public void setDate(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date=" + birth +
                '}';
    }
}
