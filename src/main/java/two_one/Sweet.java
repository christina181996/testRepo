package two_one;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
abstract class Sweet implements Comparable<Sweet> {
    private String brand;
    private int price;
    private int weight;
    private String type;

    public Sweet(String brand, int price, int weight, String type) {
        this.brand = brand;
        this.price = price;
        this.weight = weight;
        this.type = type;
    }

    @Override
    public int compareTo(Sweet o) {
        return this.price - o.price;
    }
}