package two_two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.RandomStringUtils;

public class SpeedTest {

    public static void main(String[] args) {
        System.out.println("lists");
        lists();
        System.out.println("sets");
        sets();
        System.out.println("maps");
        maps();
    }

    public static void lists() {
//arrayList
        List<String> arrayList = new ArrayList<>();

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String current = RandomStringUtils.random(10, true, true);
            arrayList.add(current);
        }
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(new Random().nextInt(arrayList.size()));
        }
        long finish1 = System.currentTimeMillis();

        System.out.println(finish1 - start1);

//linkedList
        List<String> linkedList = new LinkedList<>();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String current = RandomStringUtils.random(10, true, true);
            linkedList.add(current);
        }
        for (int i = 0; i < 10000; i++) {
            linkedList.remove(new Random().nextInt(linkedList.size()));
        }
        long finish2 = System.currentTimeMillis();

        System.out.println(finish2 - start2);
    }

    public static void sets() {
//hashSet
        Set<String> hashSet = new HashSet<>();

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String current = RandomStringUtils.random(10, true, true);
            hashSet.add(current);
            if (i % 10 == 0) {
                hashSet.remove(current);
            }
        }
        long finish1 = System.currentTimeMillis();

        System.out.println(finish1 - start1);

//treeSet
        Set<String> treeSet = new TreeSet<>();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String current = RandomStringUtils.random(10, true, true);
            treeSet.add(current);
            if (i % 10 == 0) {
                treeSet.remove(current);
            }
        }
        long finish2 = System.currentTimeMillis();

        System.out.println(finish2 - start2);
    }

    public static void maps() {
//hashMap
        Map<Integer, String> hashMap = new HashMap<>();

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String current = RandomStringUtils.random(10, true, true);
            hashMap.put(i, current);
        }
        for (int i = 0; i < 10000; i++) {
            hashMap.remove(i);
        }
        long finish1 = System.currentTimeMillis();

        System.out.println(finish1 - start1);

//treeMap
        Map<Integer, String> treeMap = new HashMap<>();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String current = RandomStringUtils.random(10, true, true);
            treeMap.put(i, current);
        }
        for (int i = 0; i < 10000; i++) {
            treeMap.remove(i);
        }
        long finish2 = System.currentTimeMillis();

        System.out.println(finish2 - start2);
    }
}
