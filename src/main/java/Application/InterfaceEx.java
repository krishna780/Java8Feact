package Application;
interface a{
    default String methodA() {
        return "welcome a";
    }
}
interface b{
    static String methodb() {
        return "welcome b";
    }
     String methodc();
}
public class InterfaceEx implements a,b{
    @Override
    public String methodA() {
        return a.super.methodA();
    }

    @Override
    public String methodc() {
        return "method c";
    }

    public static void main(String[] args) {
        System.out.println(b.methodb());
        InterfaceEx interfaceEx=new InterfaceEx();
        interfaceEx.methodc();
    }
}
