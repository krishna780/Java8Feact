package Application.threads;

import static Application.threads.Discount.Code.apply;
import static Application.threads.Util.format;

public class Discount {


    public static <R> String applyDiscount(Quote quote) throws InterruptedException {
        return quote.getShopName() + " price is " + apply(quote.getPrice(), quote.getDiscountCode());
    }

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }

        public static String applyDiscount(Quote quote) throws InterruptedException {
            return quote.getShopName() + " price is " + apply(quote.getPrice(), quote.getDiscountCode());
        }

        public static double apply(double price, Code code) throws InterruptedException {
            Util.delay();
            return format(price * (100 - code.percentage) / 100);
        }
    }
}
