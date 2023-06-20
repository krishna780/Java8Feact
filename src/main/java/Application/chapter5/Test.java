package Application.chapter5;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) {
      List<Integer> list1= List.of(4,8,5,6);
        CopyOnWriteArrayList list= new CopyOnWriteArrayList<>(list1);

        if (list.contains(8)){
            list.add(344);
        } else if (list.contains(4)) {
            list.add(877);
        }
        System.out.println(list);
    }
}
