package aaaa.task_two_one.composer;

import java.util.List;

import aaaa.three_one.UnacceptableDiscountSize;
import aaaa.task_two_one.sweets.Sweet;

public class ChristmasPresent {
    private int totalWeight;
    private int totalPrice;

    public ChristmasPresent(List<Sweet> presentContent) {
        getPresentPrice(presentContent);
        getPresentWeight(presentContent);
    }

    private void getPresentWeight(List<Sweet> list) {
        for (Sweet current : list) {
            totalPrice += current.getPrice();
        }
    }

    private void getPresentPrice(List<Sweet> list) {
        for (Sweet current : list) {
            totalWeight += current.getWeight();
        }
    }

    public void summarize() {
        System.out.println("Your present price is: " + totalPrice);
        System.out.println("Your present weight is: " + totalWeight);
    }

    public void summarize(double discount) {
        if (discount > 25 | discount < 0) {
            throw new UnacceptableDiscountSize("too much discount for particular oder: " + discount);
        }
        System.out.println("Your present price is: " + (totalPrice - (totalPrice * discount / 100)));
        System.out.println("Your present weight is: " + totalWeight);
    }
}
