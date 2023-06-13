package Application;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactoryUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {

        int[][] intege = {{5,3,10,6,11}, {20, 10, 7, 5}, {7, 13, 15, 13}};
        for (int[] integers : intege) {
            int num, temp = 0;
            for (int i = 0; i < integers.length; i++) {
                for (int j = i; j < integers.length; j++) {
                    num = integers[i] + integers[j];
                    if (num % 2 != 0 && temp < num) {
                        temp = num;
                    }

                }
            }
            if (temp == 0) {
                int asInt = Arrays.stream(integers).max().getAsInt();
                temp = asInt;
            }
            System.out.println(temp);

        }

    }
}
