package pri.arnold.generics;

import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @Author: Arnold
 * @Date: 2022/6/9 19:34
 */
public class DAOTest {

    @Test
    public void test(){
        DAO<User> dao = new DAO<>();

        dao.save("1001",new User(1001,23,"周杰伦"));
        dao.save("1002",new User(1002,50,"方文山"));
        dao.save("1003",new User(1003,44,"陈奕迅"));

        User user = dao.get("1002");
        System.out.println(user);
        System.out.println();
        dao.update("1003",new User(1003,20,"张学友"));
        dao.delete("1001");

        List<User> list = dao.list();
        list.forEach(System.out::println);
    }
}
