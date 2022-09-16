package Application.threads;

import java.util.concurrent.*;

public class CallableEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new
                Task("krishna"));
        System.out.println(future.get());
    }

    private static class Task implements Callable<String> {
        private final String str;

        public Task(String str) {
            this.str = str;
        }

        @Override
        public String call() throws Exception {
            return "hello" + str;
        }
    }
}
