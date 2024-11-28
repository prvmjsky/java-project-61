package hexlet.code.games;

public class Even2 {
    private static final int RANDOM_NUMBER_BOUND = 100;

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void start() {
        var rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        var finalRound = Engine2.getFinalRound();
        int randomNumber;
        String question;
        String correctAnswer;
        String[] questions = new String[finalRound];
        String[] correctAnswers = new String[finalRound];

        for (var i = 0; i < finalRound; i++) {
            randomNumber = Engine2.getRandomNumber(RANDOM_NUMBER_BOUND) + 1; // added 1 to avoid 0
            question = Integer.toString(randomNumber);
            correctAnswer = isEven(randomNumber) ? "yes" : "no";
            questions[i] = question;
            correctAnswers[i] = correctAnswer;
        }

        Engine2.play(rules, questions, correctAnswers);
    }
}
