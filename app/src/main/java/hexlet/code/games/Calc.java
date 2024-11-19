package hexlet.code.games;

import java.util.Scanner;

public class Calc {
    public static void play(Scanner scanner) {
        Engine.greet(scanner);

        while (Engine.isContinuing()) {
            var number1 = Engine.getRandomNumber(50);
            var number2 = Engine.getRandomNumber(50);
            char operator;

            Integer correctAnswer = switch (Engine.getRandomNumber(3)) {
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
