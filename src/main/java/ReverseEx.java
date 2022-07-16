public class ReverseEx {

    public static void main(String[] args) {
        int i = 1234;
        int reverse = 0, digit;
        while (i != 0) {
            digit = i % 10;
            reverse = reverse * 10 + digit;
            i /= 10;
        }
        System.out.println(reverse);
    }
}
