package Application.threads;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static Application.threads.Util.delay;
import static Application.threads.Util.format;

public class AsyncShop {
    private final String name;
    private final Random random;

    public AsyncShop(String name) {
        this.name = name;
        random = new Random((long) name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public CompletableFuture<Double> getPrice(String product) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return calculatePrice(product);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private double calculatePrice(String product) throws InterruptedException {
        delay();
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }
}
