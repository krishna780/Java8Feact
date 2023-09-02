package Application.chapter2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;

@Configuration
public class BeanCreationEx {

    @Bean(name = "ThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor setThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(12);
        threadPoolTaskExecutor.setMaxPoolSize(100);
        threadPoolTaskExecutor.setQueueCapacity(200);
        threadPoolTaskExecutor.setAwaitTerminationSeconds(200);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
