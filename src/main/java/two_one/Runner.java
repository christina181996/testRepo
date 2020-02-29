package two_one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    private static List<String> userInput = new ArrayList<>();

    public static void main(String[] args) {
        getUserInput();
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

    private void calculatePrice(){

    }
}
