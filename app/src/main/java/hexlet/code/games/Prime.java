package hexlet.code.games;

import java.util.Scanner;

public class Prime {
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (var i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void play(Scanner scanner) {
        Engine.greet(scanner);
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        final var RANDOM_NUMBER_BOUND = 82; // multiplication table range

        while (Engine.isContinuing()) {
            var randomNumber = Engine.getRandomNumber(RANDOM_NUMBER_BOUND);
            var correctAnswer = isPrime(randomNumber) ? "yes" : "no";

            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();

            Engine.compareAnswers(userAnswer, correctAnswer);
        }

        Engine.end(scanner);
    }
}
