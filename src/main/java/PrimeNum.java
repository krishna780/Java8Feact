public class PrimeNum {
    public static void main(String[] args) {
        boolean prime = isPrime(15);
        System.out.println(prime);
    }

    private static boolean isPrime(int i) {
        if (i <= 1) {
            return false;
        }
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
