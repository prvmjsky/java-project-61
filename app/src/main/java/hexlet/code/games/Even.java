package hexlet.code.games;

import java.util.Scanner;

public class Even {
    public static void play(Scanner scanner) {
        Engine.greet(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var randomNumberBound = 100;

        while (Engine.isContinuing()) {
            var randomNumber = Engine.getRandomNumber(randomNumberBound) + 1; // added 1 to avoid 0
            var correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();

            Engine.compareAnswers(userAnswer, correctAnswer);
        }

        Engine.end(scanner);
    }
}
