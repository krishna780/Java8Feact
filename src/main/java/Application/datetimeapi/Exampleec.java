package Application.datetimeapi;


import java.util.HashMap;
import java.util.Map;

public class Exampleec {
    public static void main(String[] args) {
        Map<String, Integer> map3=new HashMap<>();


        Map<String, Integer> map=new HashMap<>();
        map.put("a",20);
        map.put("b",34);

        Map<String, Integer> map1=new HashMap<>();
        map1.put("a",10);
        map1.put("c",34);
        for(String str:map.keySet()){
            Integer integer = map1.get(str);
            Integer integer1 = map.get(str);
            if(integer!=null){
                map3.put(str,integer1+integer);
            }else {
                map3.put(str, integer1);
            }
        }
        for(String str:map1.keySet()){
            map3.putIfAbsent(str,map1.get(str));
        }

        System.out.println(map3);

        }
}
