package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        var userChoice = scanner.next();

        switch (userChoice) {
            case "1" -> Cli.greetUser(scanner);
            case "2" -> Even.play(scanner);
            case "3" -> Calc.play(scanner);
            case "4" -> GCD.play(scanner);
            default -> scanner.close();
        }
    }
}
