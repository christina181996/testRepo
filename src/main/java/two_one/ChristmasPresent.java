package two_one;

import java.util.ArrayList;

public class ChristmasPresent {
    private ArrayList<Sweets> presentContent;

    public ChristmasPresent(ArrayList<Sweets> presentContent) {
        this.presentContent = presentContent;
    }

    public int getPresentWeight() {
        int totalWeight = 0;
        for (Sweets candiesWeights : presentContent) {
            totalWeight += candiesWeights.getSweetWeight();
        }
        return totalWeight;
    }
}
