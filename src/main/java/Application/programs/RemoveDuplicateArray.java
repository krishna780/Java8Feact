package Application.programs;

import java.util.List;

public class RemoveDuplicateArray {
    public static void main(String[] args) {
        List<String> list = new java.util.ArrayList<>(List.of("wel", "name", "wel", "ravi", "wel"));
     for(int i=0;i< list.size();i++){
         for(int j=i+1;j< list.size();j++) {
         if(list.get(i).equals(list.get(j))){
             list.remove(j);
         }
         }
         }
        System.out.println(list);
    }
}
