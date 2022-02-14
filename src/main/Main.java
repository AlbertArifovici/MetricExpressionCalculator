package testing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert desired unit: ");
        String unit = scanner.nextLine();
        Calculator calc = new Calculator();
        System.out.println(calc.calculate("10 cm + 1 m - 10 mm", unit));
    }
}

