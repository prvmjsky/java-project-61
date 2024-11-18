package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    public static void playEvenGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random random = new Random();

        for (int numberOfWins = 0; numberOfWins < 3; numberOfWins++) {
            int randomNumber = random.nextInt(100);

            System.out.println("Question: " + randomNumber);

            boolean isEven = randomNumber % 2 == 0;
            String correctAnswer = isEven ? "yes" : "no";

            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (!userAnswer.equals(correctAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }

            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
