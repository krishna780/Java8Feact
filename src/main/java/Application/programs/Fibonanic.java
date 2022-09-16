package Application.programs;

public class Fibonanic {
    public static void main(String[] args) {
        int i = 1, j = 0, s = 0;
        for (int k = 1; k < 10; k++) {
            System.out.println(s);
            s = j + i;
            j = i;
            s = j;
        }
    }
}
