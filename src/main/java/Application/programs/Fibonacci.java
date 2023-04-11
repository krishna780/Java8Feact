package Application.programs;

public class Fibonacci {
    public static void main(String[] args) {
        int i = 0, j = 1, k = 1, n = 1;
        while (n < 10) {
            System.out.println(i);
            k = i + j;
            i = j;
            j = k;
            n++;
        }
    }
}
