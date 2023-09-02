package Application.threads;

import Application.chapter4.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class ThreadsEx {
    public static void main(String[] args) {
        Thread anotherThread= new AnotherThread();
        anotherThread.setName("==Another Thread==");
        anotherThread.start();
        Runnable runnable = () -> {
            System.out.println("welcome");
        };
        runnable.run();

        Thread thread=new Thread(new MyRunnable(){
            @Override
            public void run() {
                try {

                    System.out.println(anotherThread);
                    List<Dish> collect = Dish.menu.get().stream().filter(s -> s.getCalories() > 400).collect(Collectors.toList());
                    anotherThread.join();
                    System.out.println("another thread join");
                    System.out.println(collect);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }
}
