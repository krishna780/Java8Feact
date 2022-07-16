public class Fibonacci {
    public static void main(String[] args) {
        int k = 0, j = 1, l = 0;
        for (int i = 0; i < 10; i++) {
            l = k + j;
            System.out.println(l);
            k = j;
            j = l;

        }

    }
}
