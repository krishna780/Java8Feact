package Application.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteService {
    public static void main(String[] args) {
        ExecutorService executeService = Executors.newFixedThreadPool(2);
        executeService.execute(new Task1());
        executeService.execute(new Thread(new Task2()));
    }

    private static class Task2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                System.out.print(" thread1= " + i);
            }
        }
    }

    private static class Task1 implements Runnable {

        @Override
        public void run() {
            for (int i = 101; i <= 200; i++) {
                System.out.print(" thread2= " + i);
            }
        }
    }
}