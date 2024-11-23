package hexlet.code.games;

import java.util.Scanner;

public class Even {
    private static final int RANDOM_NUMBER_BOUND = 100;

    public static void play(Scanner scanner) {
        Engine.greet(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (Engine.isGameContinuing()) {
            var randomNumber = Engine.getRandomNumber(RANDOM_NUMBER_BOUND) + 1; // added 1 to avoid 0
            var correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            System.out.println("Question: " + randomNumber);

            var userAnswer = Engine.getUserAnswer(scanner);
            Engine.compareAnswers(userAnswer, correctAnswer);
        }

        Engine.end(scanner);
    }
}
