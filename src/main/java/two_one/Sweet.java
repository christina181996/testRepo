package two_one;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
abstract class Sweet implements Comparable<Sweet> {
    private String brand;
    private int price;
    private int weight;
    private String type;

    @Override
    public int compareTo(Sweet o) {
        return this.price - o.price;
    }
}