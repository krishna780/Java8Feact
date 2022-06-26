package Application.threads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Quote {
    private final String shopName;
    private final double price;
    private final Discount.Code discountCode;

    public Quote(String shopName, double price,  Discount.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }
    public static Quote parse(String str){
        String[] split = str.split(":");
        String shopName= split[0];
        double price=Double.parseDouble(split[1]);
        Discount.Code discountCode=Discount.Code.valueOf(split[2]);
        return new Quote(shopName,price,discountCode);
    }
}
