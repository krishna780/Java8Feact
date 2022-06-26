package Application.threads;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BestPriceFinder {
  private final List<Shop> shops= Arrays.asList(new Shop("BestPrice"),
          new Shop("LetsSaveBig"),
         new Shop("MyFavoriteShop"),
         new Shop("BuyItAll"),
          new Shop("ShopEasy"));

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        }
    });

    public List<String> findPricesSequential(String product){
        List<String> collect = shops.parallelStream()
                .map(shop -> {
                    String price = null;
                    try {
                        price = shop.getPrice(product);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return price;
                })
                .map(Quote::parse)
                .map(quote -> {
                    try {
                        return Discount.applyDiscount(quote);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
        return collect;
    }
    public Stream<CompletableFuture<String>> findPriceStream(String product){
        return shops.stream().map(s->CompletableFuture.supplyAsync(()-> {
                    try {
                        return s.getPrice(product);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                },executor))
                .map(future->future.thenApply(Quote::parse))
                .map(future->future.thenCompose(quote -> CompletableFuture.supplyAsync(()-> {
                    try {
                        return Discount.applyDiscount(quote);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, executor)));
    }

}
