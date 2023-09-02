package Application.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockEx {
    public static Object lock1=new Object();
    public static Object lock2=new Object();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Thread1());
        executorService.submit(new Thread2());

    }

    private static class Thread1 extends Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("thread 1: has locked");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread 1: waiting for lock 2");
                synchronized (lock2) {
                    System.out.println("thread 1: has locked and lock2");
                }
                System.out.println("thread 1: released 2");
            }
            System.out.println("thread 1: released lock1 Existing");
        }
    }
    private  static  class Thread2 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("thread 2: has locked");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread 2: waiting for lock 1");
                synchronized (lock2) {
                    System.out.println("thread 2: has locked and lock1");
                }
                System.out.println("thread 2: released 1");
            }
            System.out.println("thread 2: released lock1 Existing");
            }
        }
    }
