package two_one;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class Runner {

    private static List<String> userInput = new ArrayList<>();
    private static List<Sweet> sweetList = new ArrayList<>();

    public static void main(String[] args) {
        getUserInput();
        getObjectsFromUserInput();
        System.out.println(sweetList);

    }

    private static void getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input name of sweet: ");
        String current = scanner.nextLine();

        if (!current.equals("quit")) {
            System.out.print("Input quantity of " + current + ": ");
            int count = scanner.nextInt();
            for (int i = 0; i < count; i++) {
                userInput.add(current);
            }
            getUserInput();
        }
    }

    private static void validateUserInput(List<String> list) {

    }

    private static void getObjectsFromUserInput() {
        FileReader fileReader = null;
        Gson gson = new Gson();

        try {
            fileReader = new FileReader("src/main/resources/sweets.json");
        } catch (FileNotFoundException fnoe) {
            System.out.println("Unable to locate file");
        }

        sweetList = List.of(gson.fromJson(fileReader, Sweet[].class));
    }
}
