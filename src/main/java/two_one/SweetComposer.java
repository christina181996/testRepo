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
    private static Map<String, Sweet> map = new HashMap<>();
    private static List<Sweet> userInputSweetList = new ArrayList<>();

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
        FileReader fileReader = null;
        Gson gson = new Gson();

        try {
            fileReader = new FileReader("src/main/resources/sweets.json");
            dataSourceSweetList = List.of(gson.fromJson(fileReader, Sweet[].class));
        } catch (FileNotFoundException fnoe) {
            System.out.println("Unable to locate file");
        }

        for (Sweet sweet : dataSourceSweetList) {
            map.put(sweet.getBrand(), sweet);
        }
    }

    private static void validateUserInput() {
        List<String> stockBrands = new ArrayList<>();
        List<String> userInputNameUniqueList = userInputNameList.stream().distinct().collect(Collectors.toList());
        for (Sweet current : dataSourceSweetList) {
            stockBrands.add(current.getBrand());
        }

        if (!stockBrands.containsAll(userInputNameUniqueList)) {
            userInputNameUniqueList.removeAll(stockBrands);
            throw new IllegalArgumentException("wrong user input(s): " + userInputNameUniqueList);
        }
    }

    private static void getUserInputSweetList() {
        for (String currentName : userInputNameList) {
            userInputSweetList.add(map.get(currentName));
        }
    }

    public static List<Sweet> getBunchOfSweets() {
        getUserInputNameList();
        getListOfObjectsFromDataSource();
        validateUserInput();
        getUserInputSweetList();
        return userInputSweetList;
    }
}
