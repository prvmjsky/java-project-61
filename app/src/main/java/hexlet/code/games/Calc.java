package hexlet.code.games;

public class Calc {
    private static final int RANDOM_NUMBER_BOUND = 50;
    private static final int RANDOM_OPERATOR_BOUND = 3;

    public static int calculate(int number1, int number2, char operator) {
        return switch (operator) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            default -> (number1 / 2) * (number2 / 2); // balancing difficulty
        };
    }

    public static void start() {
        var rules = "What is the result of the expression?";
        var finalRound = Engine.getFinalRound();

        String[] questions = new String[finalRound];
        String[] correctAnswers = new String[finalRound];

        for (var i = 0; i < finalRound; i++) {
            var number1 = Engine.getRandomNumber(RANDOM_NUMBER_BOUND);
            var number2 = Engine.getRandomNumber(RANDOM_NUMBER_BOUND);
            char operator;

            switch (Engine.getRandomNumber(RANDOM_OPERATOR_BOUND)) {
                case 0 -> operator = '+';
                case 1 -> operator = '-';
                default -> operator = '*';
            }

            var correctAnswer = calculate(number1, number2, operator);
            questions[i] = number1 + " " + operator + " " + number2;
            correctAnswers[i] = Integer.toString(correctAnswer);
        }

        Engine.play(rules, questions, correctAnswers);
    }
}
