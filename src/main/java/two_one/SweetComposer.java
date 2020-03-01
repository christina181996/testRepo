package two_one;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SweetComposer {

    private static List<String> userInputNameList = new ArrayList<>();
    private static List<Sweet> dataSourceSweetList = new ArrayList<>();
    private static Map<String, Sweet> dataSourceSweetMap = new HashMap<>();
    private static List<Sweet> userInputSweetList = new ArrayList<>();

    public static List<Sweet> getBunchOfSweets() {
        getUserInputNameList();
        getListOfObjectsFromDataSource();
        validateUserInput();
        getUserInputSweetList();
        return userInputSweetList;
    }

    private static void getUserInputNameList() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input name of sweet: ");
        String current = scanner.nextLine();

        if (!current.equals("quit")) {
            System.out.print("Input quantity of " + current + ": ");
            int count = scanner.nextInt();
            for (int i = 0; i < count; i++) {
                userInputNameList.add(current);
            }
            getUserInputNameList();
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
            System.out.println("Unable to locate file in: " + filePath);
        }

        //getting map from list of object
        for (Sweet sweet : dataSourceSweetList) {
            dataSourceSweetMap.put(sweet.getBrand(), sweet);
        }
    }

    private static void validateUserInput() {
        List<String> userInputNameUniqueList = userInputNameList.stream().distinct().collect(Collectors.toList());

        if (!dataSourceSweetMap.keySet().containsAll(userInputNameUniqueList)) {
            userInputNameUniqueList.removeAll(dataSourceSweetMap.keySet());
            throw new IllegalArgumentException("wrong user input(s): " + userInputNameUniqueList);
        }
    }

    private static void getUserInputSweetList() {
        for (String currentName : userInputNameList) {
            userInputSweetList.add(dataSourceSweetMap.get(currentName));
        }
    }
}
