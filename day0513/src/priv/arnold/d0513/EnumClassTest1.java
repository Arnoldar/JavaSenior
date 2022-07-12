package priv.arnold.d0513;

enum  EnumClassTest1 {

    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","寒冬凛冽");

    private final String seasonName;
    private final String seasonSec;

    private EnumClassTest1(String seasonName,String seasonSec){
        this.seasonName = seasonName;
        this.seasonSec = seasonSec;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonSec() {
        return seasonSec;
    }

//    @Ov
}

class EnumClass1{
    public static void main(String[] args) {
        EnumClassTest1 spring = EnumClassTest1.SPRING;
        System.out.println(spring);
    }
}