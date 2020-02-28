package calculator_1;

import java.util.Scanner;

public class Calculator {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("First number: ");
        int number1 = scanner.nextInt();

        System.out.print("Operator: ");
        String operator = scanner.next();

        System.out.print("Second number: ");
        int number2 = scanner.nextInt();

        calculate(number1, operator, number2);
    }


    private static void calculate(int number1, String operation, int number2) {
        if ((!operation.matches("[/*\\-+]")) || (operation.length() != 1)) {
            throw new IllegalArgumentException("Wrong or unsupported operator: " + operation);
        }
        String outputPrefix = "The answer is: ";

        switch (operation) {
            case "+":
                System.out.println(outputPrefix + (number1 + number2));
                break;
            case "-":
                System.out.println(outputPrefix + (number1 - number2));

                break;
            case "*":
                System.out.println(outputPrefix + (number1 * number2));

                break;
            case "/":
                try {
                    System.out.println(outputPrefix + (number1 / number2));

                } catch (ArithmeticException ae) {
                    System.out.println("Divisor can't be zero");
                }
                break;
        }
    }
}
