package Application.programs;
import java.util.Arrays;
import java.util.Random;


public class Example {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
    public static void main(String[] args) {

        int[] intege = {1,2,3,4};
        int[] ints = productExceptSelf(intege);
        System.out.println(Arrays.toString(ints));
    }
}
