package Application.Java8;

import java.util.Collections;
import java.util.List;

public class MyInterfaceImpl implements MyInterface{
    @Override
    public Integer getMaxNum(List<Integer> list) {
        Integer integer=Collections.max(list);
        return integer;
    }
}
