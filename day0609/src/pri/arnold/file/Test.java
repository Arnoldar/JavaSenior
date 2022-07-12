package pri.arnold.file;

/**
 * @Author: Arnold
 * @Date: 2022/6/10 17:12
 */
public class Test {

    @org.junit.Test
    public void test1(){
        System.out.println(getInt());
    }

    public int getInt(){
        for (int i = 0;i < 10;i++){
            System.out.println(i);
            if (i == 5){
                return tes();
            }
        }
        return 0;
    }

    public int tes(){
        return 20;
    }



}
