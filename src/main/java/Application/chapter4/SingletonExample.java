package Application.chapter4;
class Singleton{
     private static Singleton single=null;
    public  String s;

    private Singleton(){
         s="wel come to single ton";
     }

     public static Singleton singleTon(){
         if(single==null){
             single=new Singleton();
         }
        return single;
     }
        }
public class SingletonExample {
    public static void main(String[] args) {
        Singleton singleton = Singleton.singleTon();
        System.out.println(singleton.hashCode());
    }
}
