package one_one;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

public class Tasks {


    public static void main(String[] args) {
        findSecondLongerItem();
    }

    private static void findSecondLongerItem() {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String current = RandomStringUtils.randomAlphabetic(3, 12);
            list.add(current);
            System.out.println(i + 1 + " : " + current.length() + " : " + current);
        }

        int firstLongestSize = 0;
        int secondLongestSize = 0;

        System.out.println(firstLongestSize);
        System.out.println(secondLongestSize);
    }
}
