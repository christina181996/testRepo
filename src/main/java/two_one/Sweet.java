package two_one;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sweet {
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
}