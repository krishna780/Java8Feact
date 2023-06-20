package Application;

import java.util.HashMap;

public class Example {
    public static void main(String[] args) {
        int[] ints={-1,2,-1,2,-99};
        HashMap<Integer, Integer> hashMap=new HashMap<>();
        for (int in:ints){
           hashMap.put(in, hashMap.getOrDefault(in,0)+1);
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i:ints){
            Integer integer = hashMap.get(i);
            stringBuilder.append(integer).append(" ");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
