package Application.threads;

import Application.chapter4.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class AnotherThread extends Thread {
    @Override
        public void run() {
            try {
                sleep(1000);
                List<Dish> collect = Dish.menu.get().stream().filter(s -> s.getCalories() > 400).collect(Collectors.toList());
                System.out.println(collect);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

