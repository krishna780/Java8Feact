package Application.chapter5;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Chapter5 {
    public static void main(String[] args) throws IOException {
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        Trader raoul = new Trader("Raoul", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        List<Transaction> collect = transactions.stream().filter(s -> s.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());

        List<String> distinct = transactions.stream().map(s -> s.getTrader().getCity()).distinct().collect(Collectors.toList());

        List<Trader> cambridge = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());

        List<int[]> ints = IntStream.rangeClosed(1, 100)
                .boxed().flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 2 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}))
                .collect(Collectors.toList());

        long count = IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}).filter(s -> s[2] % 1 == 0))
                .count();
       int[] num= {2,3,4,6,8,9,12};

        long count1 = Arrays.stream(num).count();


        Stream<String> files = Files.lines(Paths.get("src/main/java/Application/chapter5/data.txt"), Charset.defaultCharset());
          files.flatMap(line->Arrays.stream(line.split( " ")));

        Stream<Integer> integerStream = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0]}).limit(10).map(s -> s[1]);

        double sqrt = Math.sqrt(2);

        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.filter(StringUtils::isNotBlank).map(String::toUpperCase).forEach(System.out::println);

    }
}
