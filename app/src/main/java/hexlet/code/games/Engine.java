package hexlet.code.games;

import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static final int FINAL_ROUND = 3;

    public static void play(String rules, String[] questions, String[] correctAnswers) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = SCANNER.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rules);

        var currentRound = 1;
        var isDefeated = false;
        String userAnswer;
        String correctAnswer;

        for (var i = 0; currentRound <= FINAL_ROUND && !isDefeated; i++) {
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

        if (isDefeated) {
            System.out.println("Let's try again, " + userName + "!");
        } else {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
