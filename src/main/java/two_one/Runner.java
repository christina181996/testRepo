package two_one;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        SweetComposer.addToBunch();
        SweetComposer.removeFromBunch();

        List<Sweet> georgiOrder = SweetComposer.getBunchOfSweets();

        ChristmasPresent presentForGeorgi = new ChristmasPresent(georgiOrder);
    }
}
