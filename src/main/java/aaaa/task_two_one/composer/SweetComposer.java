package aaaa.task_two_one.composer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j;
import aaaa.three_one.SweetNotFoundException;
import aaaa.three_one.UnsupportedDeletionOperationException;
import aaaa.task_two_one.sweets.Sweet;

@UtilityClass
@Log4j
public class SweetComposer {

    private static List<String> userInputNameList = new ArrayList<>();
    private static List<Sweet> dataSourceSweetList = new ArrayList<>();
    private static Map<String, Sweet> dataSourceSweetMap = new HashMap<>();
    private static List<Sweet> userInputSweetList = new ArrayList<>();

    public static List<Sweet> getBunchOfSweets() {
        getListOfObjectsFromDataSource();
        validateUserInput();
        getUserInputSweetList();
        sortCollectedList();
        return userInputSweetList;
    }

    public static void addToBunch() {
        Scanner scanner = new Scanner(System.in);

        //get sweet name from user
        System.out.print("Input name of sweet to add: ");
        String current = scanner.nextLine();

        //get count of particular sweet
        if (!current.equals("quit")) {
            System.out.print("Input quantity of " + current + " to add: ");
            int count = scanner.nextInt();
            //add user required number of sweet to the list
            for (int i = 0; i < count; i++) {
                userInputNameList.add(current);
            }
            addToBunch();
        }
    }

    public static void removeFromBunch() {
        Scanner scanner = new Scanner(System.in);

        //get sweet name from user
        System.out.print("Input name of sweet to remove: ");
        String current = scanner.nextLine();

        //get count of particular sweet
        if (!current.equals("quit")) {
            System.out.print("Input quantity of " + current + " to remove: ");
            int count = scanner.nextInt();
            //remove user required number of sweet from the list
            for (int i = 0; i < count; i++) {
                if (!userInputNameList.remove(current)) {
                    throw new UnsupportedDeletionOperationException("No enough amount added");
                }
            }
            removeFromBunch();
        }
    }

    public static void getSweetOfIndex(int index) {
        if (index <= userInputSweetList.size()) {
            System.out.println("Sweet in " + index + " index is: " + userInputSweetList.get(index).getBrand());
        } else {
            throw new IndexOutOfBoundsException("No enough items in the list");
        }
    }

    public boolean isListContainsSweet(String sweetName) {
        List<String> sweetNames = userInputSweetList
            .stream()
            .distinct()
            .map(Sweet::getBrand)
            .collect(Collectors.toList());

        if (!sweetNames.contains(sweetName)) {
            throw new SweetNotFoundException("Sweet wasn't found in user ordered list");
        } else {
            System.out.println(sweetName + " exist in user ordered list");
            return true;
        }
    }

    private static void getListOfObjectsFromDataSource() {
        FileReader fileReader;
        String filePath = "src/main/resources/sweets.json";
        try {
            fileReader = new FileReader(filePath);
            //getting list of objects from data source
            dataSourceSweetList = List.of(new Gson().fromJson(fileReader, Sweet[].class));
        } catch (FileNotFoundException fnoe) {
            log.error("Unable to locate file in: " + filePath);
        }

        //getting map from list of object
        for (Sweet sweet : dataSourceSweetList) {
            dataSourceSweetMap.put(sweet.getBrand(), sweet);
        }
    }

    private static void validateUserInput() {
        //get unique list total user input
        List<String> userInputNameUniqueList = userInputNameList.stream().distinct().collect(Collectors.toList());

        //validate if user wants only sweet which is in our data source
        if (!dataSourceSweetMap.keySet().containsAll(userInputNameUniqueList)) {
            userInputNameUniqueList.removeAll(dataSourceSweetMap.keySet());
            throw new IllegalArgumentException("wrong user input(s): " + userInputNameUniqueList);
        }
    }

    private static void getUserInputSweetList() {
        //fill list of sweets based on user need
        for (String currentName : userInputNameList) {
            userInputSweetList.add(dataSourceSweetMap.get(currentName));
        }
    }

    private static void sortCollectedList() {
        Collections.sort(userInputSweetList);
    }
}