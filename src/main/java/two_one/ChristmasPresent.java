package two_one;

import java.util.ArrayList;

public class ChristmasPresent {
    private static ArrayList<Sweet> presentContent;
    private static int totalWeight = getPresentWeight();
    private static int totalPrice = getPresentPrice();

    public ChristmasPresent(ArrayList<Sweet> presentContent) {
        this.presentContent = presentContent;
    }

    public static int getPresentWeight() {
        int presentWeight = 0;
        for (Sweet candiesWeights : presentContent) {
            presentWeight += candiesWeights.getWeight();
        }
        return presentWeight;
    }

    public static int getPresentPrice() {
        int presentPrice = 0;
        for (Sweet candiesPrices : presentContent) {
            presentPrice += candiesPrices.getPrice();
        }
        return presentPrice;
    }
}
