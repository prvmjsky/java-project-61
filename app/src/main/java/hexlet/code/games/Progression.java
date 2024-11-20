package hexlet.code.games;

import java.util.Arrays;
import java.util.Scanner;

public class Progression {
    public static int[] getRandomProgression() {
        int[] progression = new int[10];
        progression[0] = Engine.getRandomNumber(20);
        var step = Engine.getRandomNumber(10) + 1;

        for (var i = 1; i < 10; i++) {
            progression[i] = progression[i - 1] + step;
        }

        return progression;
    }

    public static void play(Scanner scanner) {
        Engine.greet(scanner);

        while (Engine.isContinuing()) {
            int[] progression = getRandomProgression();
            var hiddenValue = progression[Engine.getRandomNumber(10)];

            var correctAnswer = Integer.toString(hiddenValue);
            var questProgression = Arrays.toString(progression).replace(correctAnswer, "..");

            System.out.println("What number is missing in the progression?");
            System.out.println("Question: " + questProgression);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();

            Engine.compareAnswers(userAnswer, correctAnswer);
        }

        Engine.end(scanner);
    }
}