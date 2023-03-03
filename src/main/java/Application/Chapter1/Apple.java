package Application.Chapter1;

import lombok.*;

import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Apple {

    private int size;
    private String name;
    private int weight;
    private Color color;

    public Apple(int size, Color color) {
        this.size=size;
        this.color=color;
    }

    public Apple(Integer integer) {
    }
}
enum Color {
    RED,
    GREEN
}
