package Application.programs;

public class Fibonanic {
    public static void main(String[] args) {
        int i = 0, j = 1, s = 0;
        for (int k = 1; k < 10; k++) {
            System.out.println(i);
            s = j + i;
           i=j;
           j=s;
        }
    }
}
