package two_one;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        SweetComposer.addToBunch();
        SweetComposer.removeFromBunch();
        List<Sweet> georgiOrder = SweetComposer.getBunchOfSweets();

        SweetComposer.isListContainsSweet("Roshen");
        SweetComposer.getSweetOfIndex(7);

        ChristmasPresent presentForGeorgi = new ChristmasPresent(georgiOrder);
    }
}
