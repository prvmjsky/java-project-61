package hexlet.code.games;

import java.util.Scanner;

public class GCD {
    private static final int RANDOM_NUMBER_BOUND = 100;

    public static int getGCD(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : getGCD(b, a % b);
    }

    public static void play(Scanner scanner) {
        Engine.greet(scanner);

        while (Engine.isContinuing()) {
            var number1 = Engine.getRandomNumber(RANDOM_NUMBER_BOUND) + 1; // added 1 to avoid 0
            var number2 = Engine.getRandomNumber(RANDOM_NUMBER_BOUND) + 1;
            int correctAnswer = getGCD(number1, number2);

            System.out.println("Find the greatest common divisor of given numbers.");
            System.out.println("Question: " + number1 + " " + number2);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();

            Engine.compareAnswers(userAnswer, Integer.toString(correctAnswer));
        }

        Engine.end(scanner);
    }
}
