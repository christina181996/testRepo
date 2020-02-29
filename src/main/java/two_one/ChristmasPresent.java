package two_one;

import java.util.ArrayList;

public class ChristmasPresent {
    private ArrayList<Sweet> presentContent;

    public ChristmasPresent(ArrayList<Sweet> presentContent) {
        this.presentContent = presentContent;
    }

    public int getPresentWeight() {
        int totalWeight = 0;
        for (Sweet candiesWeights : presentContent) {
            totalWeight += candiesWeights.getWeight();
        }
        return totalWeight;
    }
}
