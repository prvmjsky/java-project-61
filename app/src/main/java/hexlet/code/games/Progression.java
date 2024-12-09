package hexlet.code.games;

public class Progression {
    private static final int SIZE = 10;
    private static final int SEED_BOUND = 20;
    private static final int STEP_BOUND = 10;
    private static final int HIDDEN_ELEMENT_INDEX_BOUND = 10;

    private static String[] getRandomProgression(int size, int seed, int step) {
        String[] progression = new String[size];
        var currentNumber = seed;

        for (var i = 0; i < size; i++) {
            progression[i] = Integer.toString(currentNumber);
            currentNumber += step;
        }

        return progression;
    }

    public static void start() {
        var rules = "What number is missing in the progression?";

        String[] questions = new String[Engine.FINAL_ROUND];
        String[] correctAnswers = new String[Engine.FINAL_ROUND];

        for (var i = 0; i < Engine.FINAL_ROUND; i++) {
            var seed = Engine.getRandomNumber(SEED_BOUND);
            var step = Engine.getRandomNumber(STEP_BOUND) + 1;
            String[] progression = getRandomProgression(SIZE, seed, step);

            var hiddenElementIndex = Engine.getRandomNumber(HIDDEN_ELEMENT_INDEX_BOUND);
            var hiddenElement = progression[hiddenElementIndex];
            progression[hiddenElementIndex] = "..";

            questions[i] = String.join(" ", progression);
            correctAnswers[i] = hiddenElement;
        }

        Engine.play(rules, questions, correctAnswers);
    }
}
