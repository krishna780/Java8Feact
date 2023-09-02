package Application.Stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {
        String[] strings={"one", "two","three", "four"};
        Stream<String> sorted = Arrays.stream(strings).sorted(Comparator.naturalOrder());

        var stream=Stream.of("five","six", "seven")
               .map(String::toUpperCase);
        //Stream.concat(sorted, stream).map(s->s.charAt(0)+" - "+s).forEach(System.out::println);

        Random random=new Random();
        List<Integer> collect = Stream.generate(() -> random.nextInt(100))
                .limit(10).sorted().collect(Collectors.toList());

      //  Stream.iterate(1,n->n+1).limit(10).forEach(System.out::print);
        BigDecimal decimal=new BigDecimal(10000);
        System.out.println(decimal.doubleValue());
    }

}
