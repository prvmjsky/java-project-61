package hexlet.code.games;

import java.util.Scanner;

public class Even {
    public static void play(Scanner scanner) {
        Game.greet(scanner);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (Game.isContinuing()) {
            var randomNumber = Game.getRandomNumber();
            var correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();

            Game.compareAnswers(userAnswer, correctAnswer);
        }

        Game.end(scanner);
    }
}
