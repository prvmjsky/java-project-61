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

    public static void start() {
        var rules = "What number is missing in the progression?";
        var finalRound = Engine.getFinalRound();

        String[] questions = new String[finalRound];
        String[] correctAnswers = new String[finalRound];

        for (var i = 0; i < finalRound; i++) {
            int[] progression = getRandomProgression();
            var hiddenElement = progression[Engine.getRandomNumber(RANDOM_HIDDEN_ELEMENT_BOUND)];

            StringJoiner progressionForQuestion = new StringJoiner(" ");
            for (int num : progression) {
                if (num == hiddenElement) {
                    progressionForQuestion.add("..");
                } else {
                    progressionForQuestion.add(Integer.toString(num));
                }
            }

            questions[i] = progressionForQuestion.toString();
            correctAnswers[i] = Integer.toString(hiddenElement);
        }

        Engine.play(rules, questions, correctAnswers);
    }
}
