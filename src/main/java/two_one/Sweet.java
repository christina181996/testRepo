package two_one;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sweet)) {
            return false;
        }
        Sweet sweet = (Sweet) o;
        return price == sweet.price &&
            weight == sweet.weight &&
            brand.equals(sweet.brand) &&
            type.equals(sweet.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price, weight, type);
    }
}