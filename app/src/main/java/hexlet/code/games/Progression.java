package hexlet.code.games;

import java.util.Scanner;
import java.util.StringJoiner;

public class Progression {
    public static int[] getRandomProgression() {
        var progressionSize = 10;
        var randomElementOfProgressionBound = 20;
        var randomStepBound = 10;

        int[] progression = new int[progressionSize];
        progression[0] = Engine.getRandomNumber(randomElementOfProgressionBound);
        var step = Engine.getRandomNumber(randomStepBound) + 1;

        for (var i = 1; i < progressionSize; i++) {
            progression[i] = progression[i - 1] + step;
        }

        return progression;
    }

    public static void play(Scanner scanner) {
        Engine.greet(scanner);

        var randomHiddenElementBound = 10;

        while (Engine.isContinuing()) {
            int[] progression = getRandomProgression();
            var hiddenElement = progression[Engine.getRandomNumber(randomHiddenElementBound)];
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
