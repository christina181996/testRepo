package task_two_one;

import java.util.List;

import task_two_one.composer.ChristmasPresent;
import task_two_one.composer.SweetComposer;
import task_two_one.sweets.Sweet;

public class Runner {

    public static void main(String[] args) {

        SweetComposer.addToBunch();
        SweetComposer.removeFromBunch();
        List<Sweet> georgiOrder = SweetComposer.getBunchOfSweets();

        SweetComposer.getSweetOfIndex(4);
        SweetComposer.isListContainsSweet("Grand candy");

        ChristmasPresent presentForGeorgi = new ChristmasPresent(georgiOrder);
        presentForGeorgi.summarize(10);
        presentForGeorgi.summarize(27);
    }
}
