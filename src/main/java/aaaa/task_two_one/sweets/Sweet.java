package aaaa.task_two_one.sweets;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Sweet implements Comparable<Sweet> {
    private String brand;
    private int price;
    private int weight;
    private String type;

    @Override
    public int compareTo(Sweet o) {
        return this.price - o.price;
    }
}