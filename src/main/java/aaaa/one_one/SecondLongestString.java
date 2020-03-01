package aaaa.one_one;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

public class SecondLongestString {

    public static void main(String[] args) {
        List<String> initialList = randomStringListGenerator();
        List<String> output = new ArrayList<>();
        int maxLength = 0;
        int secondMaxLength = 0;

        //find longest String length
        for (String current : initialList) {
            if (current.length() > maxLength) {
                maxLength = current.length();
            }
        }
        //find 2nd longest String length
        for (String current : initialList) {
            if (current.length() != maxLength && current.length() > secondMaxLength) {
                secondMaxLength = current.length();
            }
        }

        //find elements which length = secondMaxLength and the items add to output list
        for (String current : initialList) {
            if (current.length() == secondMaxLength) {
                output.add(current);
            }
        }
        System.out.println(output);
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
}
