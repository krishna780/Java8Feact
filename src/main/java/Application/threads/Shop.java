package Application.threads;

import lombok.Data;

import java.util.Random;

import static Application.threads.Util.delay;
import static Application.threads.Util.format;


@Data
public class Shop {
    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        this.random = new Random((long) name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getPrice(final String product) throws InterruptedException {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return name + ":" + price + ":" + code;
    }

    private double calculatePrice(String product) throws InterruptedException {
        delay();
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }

    public String getName() {
        return name;
    }
}
