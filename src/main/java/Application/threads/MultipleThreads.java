package Application.threads;

public class MultipleThreads {
    public static void main(String[] args) {
        CountDown countDown=new CountDown();
        CountDownThread t1=new CountDownThread(countDown);
        t1.setName("Thread 1");
        CountDownThread t2=new CountDownThread(countDown);
        t2.setName("Thread 2");
        t1.start();
        t2.start();

    }
}

class CountDown{
    public void doCountDown(){
        String color;
        switch (Thread.currentThread().getName()){
            case  "Thread 1":
                color= ThreadColor.ANSI_CYAN;
                break;

            case "Thread 2":
                color=ThreadColor.ANSI_RED;
                break;
            default:
                color=ThreadColor.ANSI_GREEN;
                break;
        }
        for(int i=10;i>0;i--){
            System.out.println(color+Thread.currentThread().getName()+": i ="+i);
        }
    }
}

class CountDownThread extends Thread{
    private CountDown countDown;

    public CountDownThread(CountDown countDown) {
        this.countDown = countDown;
    }

    public void run(){
        countDown.doCountDown();
    }
}
