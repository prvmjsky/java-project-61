package hexlet.code.games;

public class Even {
    private static final int RANDOM_NUMBER_BOUND = 100;

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void start() {
        var rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[] questions = new String[Engine.FINAL_ROUND];
        String[] correctAnswers = new String[Engine.FINAL_ROUND];

        for (var i = 0; i < Engine.FINAL_ROUND; i++) {
            var number = Engine.getRandomNumber(RANDOM_NUMBER_BOUND) + 1; // added 1 to avoid 0
            questions[i] = Integer.toString(number);
            correctAnswers[i] = isEven(number) ? "yes" : "no";
        }

        Engine.play(rules, questions, correctAnswers);
    }
}
