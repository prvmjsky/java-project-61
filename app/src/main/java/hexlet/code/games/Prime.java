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
        var finalRound = Engine.getFinalRound();

        String[] questions = new String[finalRound];
        String[] correctAnswers = new String[finalRound];

        for (var i = 0; i < finalRound; i++) {
            var number = Engine.getRandomNumber(RANDOM_NUMBER_BOUND) + 1; // added 1 to avoid 0
            questions[i] = Integer.toString(number);
            correctAnswers[i] = isPrime(number) ? "yes" : "no";
        }

        Engine.play(rules, questions, correctAnswers);
    }
}
