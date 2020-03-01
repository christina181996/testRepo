package two_one;

import java.util.List;

public class ChristmasPresent {
    private int totalWeight;
    private int totalPrice;

    public ChristmasPresent(List<Sweet> presentContent) {
        getPresentPrice(presentContent);
        getPresentWeight(presentContent);
        closeUp();
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

    private void closeUp() {
        System.out.println("Your present price is: " + totalPrice);
        System.out.println("Your present weight is: " + totalWeight);
    }

}
