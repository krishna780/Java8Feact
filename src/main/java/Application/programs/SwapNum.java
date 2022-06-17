package Application.programs;

public class SwapNum {
    public static void main(String[] args) {
        int a=10,b=20;
        b=a+b;
        a=b-a;
        b=b-a;
        System.out.println(a+"  "+b);
    }
}
