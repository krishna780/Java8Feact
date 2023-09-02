package Application.chapter2;

import java.util.Optional;
import java.util.stream.LongStream;

public class JavaParallelEx {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(1, 1000000000)
                .reduce(0L, Long::sum);
        System.out.println(reduce);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);

    }
}
