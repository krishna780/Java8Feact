package Application.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceEx {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());

        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());
        executorService.submit(new AnotherThread());

    }
}
