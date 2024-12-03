package hexlet.code.games;

public class GCD {
    private static final int RANDOM_NUMBER_BOUND = 100;

    private static int getGCD(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : getGCD(b, a % b);
    }

    public static void start() {
        var rules = "Find the greatest common divisor of given numbers.";

        String[] questions = new String[Engine.FINAL_ROUND];
        String[] correctAnswers = new String[Engine.FINAL_ROUND];

        for (var i = 0; i < Engine.FINAL_ROUND; i++) {
            var number1 = Engine.getRandomNumber(RANDOM_NUMBER_BOUND) + 1; // added 1 to avoid 0
            var number2 = Engine.getRandomNumber(RANDOM_NUMBER_BOUND) + 1;
            var correctAnswer = getGCD(number1, number2);

            questions[i] = number1 + " " + number2;
            correctAnswers[i] = Integer.toString(correctAnswer);
        }

        Engine.play(rules, questions, correctAnswers);
    }
}
