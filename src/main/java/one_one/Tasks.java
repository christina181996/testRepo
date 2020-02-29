package one_one;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class Tasks {


    static List<String> randomStringList = randomStringListGenerator();

    public static void main(String[] args) {
        System.out.format("The second largest String is: %s with %d length", findSecondLongerItem(), findSecondLongerItem().length());
    }

    private static List<String> randomStringListGenerator() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String current = RandomStringUtils.randomAlphabetic(3, 12);
            list.add(current);
            System.out.println(i + 1 + ": " + current.length() + ": " + current);
        }
        return list;
    }

    private static String findSecondLongerItem() {
        int maxLength = 0;
        String longestString = null;
        String secondLongestString = null;
        for (String values : randomStringList) {
            if (values.length() > maxLength) {
                maxLength = values.length();
                longestString = values;
            }
        }
//        for (String values : randomStringList) {
//            assert longestString != null;
//            if (values.length() < longestString.length()) {
//                secondLongestString = values;
//            }
//        }
        return longestString;
    }
}
