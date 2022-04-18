
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.sort;

public class FilterExample {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product(10, "mac", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));
        productsList.add(new Product(6, null, 0f));
        List<Product> collect = productsList.stream()
                .filter(s -> StringUtils.isNotBlank(s.getName()))
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}