package Application.threads;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Util {
    private static final Random RANDOM= new Random(0);
    private static final DecimalFormat formatter= new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

    public static void delay() throws InterruptedException {
        int delay=1000;
        Thread.sleep(delay);
    }
    public static double format(double number){
        synchronized (formatter){
            return  new Double(formatter.format(number));
        }
    }
    public static <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> future){
        return CompletableFuture.supplyAsync(()->future.stream()
                .map(f->f.join())
                .collect(Collectors.<T>toList())
        );
    }
}
