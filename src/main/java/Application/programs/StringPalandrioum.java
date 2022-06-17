package Application.programs;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringPalandrioum {
    public static void main(String[] args) {
     String str="bob";
        String[] split = str.split("");
        StringBuilder sb=new StringBuilder();
        for (int i= split.length-1;i>=0;i--){
            sb.append(split[i]);
        }
        System.out.println(sb);
        if(StringUtils.equals(sb,str)){
            System.out.println(sb);
        }
    }
}
