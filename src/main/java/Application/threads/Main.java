package Application.threads;

public class Main {
    public static void main(String[] args) {

        Thread anotherThread=new AnotherThread();
        anotherThread.start();
        new Thread(() -> System.out.println("new thread"+Thread.currentThread()
                .getName())).start();

    }

}
