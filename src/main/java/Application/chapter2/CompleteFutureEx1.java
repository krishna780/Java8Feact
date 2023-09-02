package Application.chapter2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteFutureEx1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        create().thenApply(CompleteFutureEx1::fetchString).thenAccept(System.out::println);
    }
    private static String fetchString(Integer s) {
        return "welcome"+s;
    }
    public static CompletableFuture<Integer> create(){
        return CompletableFuture.supplyAsync(()->2);
    }

}
