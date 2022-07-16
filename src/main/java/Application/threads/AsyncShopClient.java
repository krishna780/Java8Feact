package Application.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncShopClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsyncShop asyncShop = new AsyncShop("BestShop");
        long nanoTime = System.nanoTime();
        Future<Double> future = asyncShop.getPrice("myPhone");
        long invocationTime = ((System.nanoTime() - nanoTime) / 1_000_000);
        System.out.println("invocationTime" + invocationTime);
        Double aDouble = future.get();
        System.out.println(aDouble);
        long retrivalTime = ((System.nanoTime() - nanoTime) / 1_000_000);
        System.out.println("retrivalTime" + retrivalTime);
    }
}
