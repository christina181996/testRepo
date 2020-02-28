package two_two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class SpeedTest {

    public static void main(String[] args) {

    }

    public static void lists() {

        List<String> arrayList = new ArrayList<>();

        long start1 = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(RandomStringUtils.random(10, true, true));
        }
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(new Random().nextInt(arrayList.size()));
        }

        long finish1 = System.currentTimeMillis();

        long duration1 = finish1 - start1;
        System.out.println(duration1);




        List<String> linkedList = new LinkedList<>();
        long start2 = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(RandomStringUtils.random(10, true, true));
        }
        for (int i = 0; i < 10000; i++) {
            linkedList.remove(new Random().nextInt(arrayList.size()));
        }

        long finish2 = System.currentTimeMillis();

        long duration2 = finish2 - start2;
        System.out.println(duration2);
    }
}
