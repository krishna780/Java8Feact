package Application.threads;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class MyProducer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayBlockingQueue<String> buffer=new ArrayBlockingQueue<>(10);
        ReentrantLock reentrantLock=new ReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        var producer=new Producer(buffer, ThreadColor.ANSI_GREEN);
        var consumer1=new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, reentrantLock);
        var consumer2=new MyConsumer(buffer, ThreadColor.ANSI_YELLOW, reentrantLock);
           executorService.execute(producer);
           executorService.submit(consumer1);
           executorService.submit(consumer2);

        Future<String> submit = executorService.submit(() -> {
            System.out.println(ThreadColor.ANSI_RED + "call back method");
            return "This is a call back methods";
        });
        System.out.println(submit.get());

        executorService.shutdown();


    }
}
@AllArgsConstructor
class Producer implements Runnable{

    private final ArrayBlockingQueue<String> buffer;
    private String color;

    @Override
    public void run() {
        Random random=new Random();
        String[] nums={"1","2","3","4","5"};
         for (String s:nums){
             try {
             System.out.println(color+"Addding.."+s);
                    buffer.add(s);
             Thread.sleep(random.nextInt(1000));
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
        System.out.println(color+"adding EOf and existing...");
         buffer.add("EOF")  ;
    }
}
@AllArgsConstructor
class MyConsumer implements Runnable{
    private final ArrayBlockingQueue<String> buffer;
    private String color;
    private ReentrantLock reentrantLock;

    @Override
    public void run() {
            while (true){
                reentrantLock.lock();
                if(buffer.isEmpty()){
                    reentrantLock.unlock();
                    continue;
                }

                if (buffer.peek().equals("EOF")){
                    reentrantLock.unlock();
                    System.out.println(color+" Existing");
                    break;
                }else {
                    try {
                        System.out.println(color+"removed"+buffer.take());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                reentrantLock.unlock();

            }
    }
}