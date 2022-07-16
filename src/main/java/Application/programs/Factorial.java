package Application.programs;

public class Factorial {
    public static void main(String[] args) {
        int fact = fact(5);
        System.out.println(fact);
    }

    private static int fact(int n) {
        if (n == 1) {
            return n;
        }
        return (n * fact(n - 1));
    }
}