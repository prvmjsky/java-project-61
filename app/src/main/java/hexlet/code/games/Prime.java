package hexlet.code.games;

public class Prime {
    private static final int RANDOM_NUMBER_BOUND = 82; // multiplication table range

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (var i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void start() {
        var rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        String[] questions = new String[Engine.FINAL_ROUND];
        String[] correctAnswers = new String[Engine.FINAL_ROUND];

        for (var i = 0; i < Engine.FINAL_ROUND; i++) {
            var number = Utils.getRandomNumber(1, RANDOM_NUMBER_BOUND);
            questions[i] = Integer.toString(number);
            correctAnswers[i] = isPrime(number) ? "yes" : "no";
        }

        Engine.play(rules, questions, correctAnswers);
    }
}
