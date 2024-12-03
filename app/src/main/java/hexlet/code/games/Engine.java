package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOMIZER = new Random();

    public static final int FINAL_ROUND = 3;
    private static int currentRound = 1;
    private static boolean isDefeated = false;

    private static String userName;

    public static int getRandomNumber(int bound) {
        return RANDOMIZER.nextInt(bound);
    }

    public static boolean isGameContinuing() {
        return currentRound <= FINAL_ROUND && !isDefeated;
    }

    public static void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = SCANNER.nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    public static void end() {
        if (isDefeated) {
            System.out.println("Let's try again, " + userName + "!");
        } else {
            System.out.println("Congratulations, " + userName + "!");
        }

        SCANNER.close();
    }

    public static void play(String rules, String[] questions, String[] correctAnswers) {
        greet();
        System.out.println(rules);

        String userAnswer;
        String correctAnswer;

        for (var i = 0; isGameContinuing(); i++) {
            System.out.println("Question: " + questions[i]);
            System.out.print("Your answer: ");
            userAnswer = SCANNER.nextLine();
            correctAnswer = correctAnswers[i];

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                currentRound++;
            } else {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                isDefeated = true;
            }
        }

        end();
    }
}
