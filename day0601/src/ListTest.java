import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Arnold
 * @Date: 2022/6/2 9:06
 */
public class ListTest {

    public static List getNewList(List list){
        HashSet hashSet = new HashSet();
        hashSet.addAll(list);
        return new ArrayList(hashSet);
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(1);
        List newList = ListTest.getNewList(arrayList);
        Iterator iterator = newList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
