package Application;

public class FibonaciEx {
    public static void main(String[] args) {
        int i=1,j = 0,k = 0;
        for (int s=0;s<10;s++){
            System.out.println(k);
            k=i+j;
            i=j;
            j=k;
        }
    }
}
