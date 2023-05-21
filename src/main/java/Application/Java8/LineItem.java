package Application.Java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
public class LineItem {
    private Integer id;
    private String item;
    private Integer qty;
    private BigDecimal price;
    private BigDecimal total;
}


