package priv.arnold.d0513;

/**
 * @Author: Arnold
 * @Date: 2022/5/16 14:46
 */
public class EnumClassTest {

    private final String seasonName;
    private final String seasonSec;

    private EnumClassTest(String seasonName,String seasonSec){
        this.seasonName = seasonName;
        this.seasonSec = seasonSec;
    }

    public static final EnumClassTest SPRING = new EnumClassTest("春天","春暖花开");
    public static final EnumClassTest SUMMER = new EnumClassTest("夏天","夏日炎炎");
    public static final EnumClassTest AUTUMN = new EnumClassTest("秋天","秋高气爽");
    public static final EnumClassTest WINTER = new EnumClassTest("冬天","寒冬凛冽");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonSec() {
        return seasonSec;
    }

    @Override
    public String toString() {
        return "EnumClassTest{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonSec='" + seasonSec + '\'' +
                '}';
    }
}

class EnumClass{
    public static void main(String[] args) {
        EnumClassTest spring = EnumClassTest.SPRING;
        System.out.println(spring);
    }
}
