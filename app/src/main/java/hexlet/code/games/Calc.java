package hexlet.code.games;

import java.util.Scanner;

public class Calc {
    public static void play(Scanner scanner) {
        Engine.greet(scanner);

        var randomNumberBound = 50;
        var randomOperatorBound = 3;

        while (Engine.isContinuing()) {
            var number1 = Engine.getRandomNumber(randomNumberBound);
            var number2 = Engine.getRandomNumber(randomNumberBound);
            char operator;

            int correctAnswer = switch (Engine.getRandomNumber(randomOperatorBound)) {
                case 0 -> {
                    operator = '+';
                    yield number1 + number2;
                }
                case 1 -> {
                    operator = '-';
                    yield number1 - number2;
                }
                default -> {
                    operator = '*';
                    // balancing difficulty
                    number2 = number2 / 2;
                    number1 = number1 / 2;
                    yield number1 * (number2);
                }
            };

            System.out.println("What is the result of the expression?");
            System.out.println("Question: " + number1 + " " + operator + " " + number2);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();

            Engine.compareAnswers(userAnswer, Integer.toString(correctAnswer));
        }

        Engine.end(scanner);
    }
}
