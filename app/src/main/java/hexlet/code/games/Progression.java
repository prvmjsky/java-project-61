package hexlet.code.games;

import java.util.Scanner;
import java.util.StringJoiner;

public class Progression {
    private static final int PROGRESSION_SIZE = 10;
    private static final int RANDOM_ELEMENT_OF_PROGRESSION_BOUND = 20;
    private static final int RANDOM_STEP_BOUND = 10;
    private static final int RANDOM_HIDDEN_ELEMENT_BOUND = 10;

    public static int[] getRandomProgression() {

        int[] progression = new int[PROGRESSION_SIZE];
        progression[0] = Engine.getRandomNumber(RANDOM_ELEMENT_OF_PROGRESSION_BOUND);
        var step = Engine.getRandomNumber(RANDOM_STEP_BOUND) + 1;

        for (var i = 1; i < PROGRESSION_SIZE; i++) {
            progression[i] = progression[i - 1] + step;
        }

        return progression;
    }

    public static void start(Scanner scanner) {
        Engine.greet(scanner);
        System.out.println("What number is missing in the progression?");

        while (Engine.isGameContinuing()) {
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

            System.out.println("Question: " + progressionForQuestion);

            var userAnswer = Engine.getUserAnswer(scanner);
            Engine.compareAnswers(userAnswer, correctAnswer);
        }

        Engine.end(scanner);
    }
}
