package hexlet.code.games;

import java.util.Scanner;

public class Even {
    public static void play(Scanner scanner) {
        Engine.greet(scanner);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (Engine.isContinuing()) {
            var randomNumber = Engine.getRandomNumber(100) + 1; // added 1 to avoid 0 and keep equal chances
            var correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();

            Engine.compareAnswers(userAnswer, correctAnswer);
        }

        Engine.end(scanner);
    }
}