package two_one;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        List<Sweet> georgiOrder = SweetComposer.getBunchOfSweets();

        ChristmasPresent presentForGeori = new ChristmasPresent(georgiOrder);
    }
}
