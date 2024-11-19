package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    public static void playEvenGame(Scanner scanner) {
        Game.greet(scanner);
        Random random = new Random();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (Game.isContinuing()) {
            var randomNumber = random.nextInt(100);
            var correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();

            Game.compareAnswers(userAnswer, correctAnswer);
        }

        Game.end(scanner);
    }
}
