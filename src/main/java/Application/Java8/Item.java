package Application.Java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Item {

    private String name;
    private int qty;
    private BigDecimal price;
}