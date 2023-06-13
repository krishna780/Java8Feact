package Application.threads;

import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

public class AsyncShopClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsyncShop asyncShop = new AsyncShop("BestShop");
        long nanoTime = System.nanoTime();
        CompletableFuture<Double> future = asyncShop.getPrice("myPhone");
        long invocationTime = ((System.nanoTime() - nanoTime) / 1_000_000);
        System.out.println("invocationTime" + invocationTime);
        Double aDouble = future.get();
        System.out.println(aDouble);
        long retrivalTime = ((System.nanoTime() - nanoTime) / 1_000_000);
        System.out.println("retrivalTime" + retrivalTime);


    }

    @Bean("threads")
    public Executor executorService(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setQueueCapacity(100);
        threadPoolTaskExecutor.setBeanName("thread_");
        threadPoolTaskExecutor.setAwaitTerminationMillis(1000);
        return  threadPoolTaskExecutor;
    }
}
