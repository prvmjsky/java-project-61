package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static String userName;
    private static boolean defeated = false;
    private static int round = 1;
    private static Random randomizer = new Random();

    public static void greet(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }

    public static boolean isContinuing() {
        return round <= 3 && !defeated;
    }

    public static int getRandomNumber(int bound) {
        return randomizer.nextInt(bound);
    }

    public static void compareAnswers(String userAnswer, String correctAnswer) {
        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            round++;
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
            defeated = true;
        }
    }

    public static void end(Scanner scanner) {
        if (defeated) {
            System.out.println("Let's try again, " + userName + "!");
            scanner.close();
        } else {
            System.out.println("Congratulations, " + userName + "!");
            scanner.close();
        }
    }
}
