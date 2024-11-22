package hexlet.code.games;

import java.util.Scanner;
import java.util.StringJoiner;

public class Progression {
    public static int[] getRandomProgression() {
        final var PROGRESSION_SIZE = 10;
        final var RANDOM_ELEMENT_OF_PROGRESSION_BOUND = 20;
        final var RANDOM_STEP_BOUND = 10;

        int[] progression = new int[PROGRESSION_SIZE];
        progression[0] = Engine.getRandomNumber(RANDOM_ELEMENT_OF_PROGRESSION_BOUND);
        var step = Engine.getRandomNumber(RANDOM_STEP_BOUND) + 1;

        for (var i = 1; i < PROGRESSION_SIZE; i++) {
            progression[i] = progression[i - 1] + step;
        }

        return progression;
    }

    public static void play(Scanner scanner) {
        Engine.greet(scanner);

        final var RANDOM_HIDDEN_ELEMENT_BOUND = 10;

        while (Engine.isContinuing()) {
            int[] progression = getRandomProgression();
            var hiddenElement = progression[Engine.getRandomNumber(RANDOM_HIDDEN_ELEMENT_BOUND)];
            var correctAnswer = Integer.toString(hiddenElement);

            StringJoiner progressionForQuestion = new StringJoiner(" ");
            for (int num : progression) {
                if (num == hiddenElement) {
                    progressionForQuestion.add("..");
                } else {
                    progressionForQuestion.add(Integer.toString(num));
                }
            }

            System.out.println("What number is missing in the progression?");
            System.out.println("Question: " + progressionForQuestion);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();

            Engine.compareAnswers(userAnswer, correctAnswer);
        }

        Engine.end(scanner);
    }
}
