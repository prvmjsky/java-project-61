package hexlet.code.games;

public class Calc {
    private static final int RANDOM_NUMBER_BOUND = 50;
    private static final int RANDOM_OPERATOR_BOUND = 3;

    public static Integer calculate(int number1, int number2, char operator) {
        return switch (operator) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            default -> null;
        };
    }

    public static void start() {
        var rules = "What is the result of the expression?";

        String[] questions = new String[Engine.FINAL_ROUND];
        String[] correctAnswers = new String[Engine.FINAL_ROUND];

        for (var i = 0; i < Engine.FINAL_ROUND; i++) {
            var number1 = Engine.getRandomNumber(RANDOM_NUMBER_BOUND);
            var number2 = Engine.getRandomNumber(RANDOM_NUMBER_BOUND);
            char operator;

            switch (Engine.getRandomNumber(RANDOM_OPERATOR_BOUND)) {
                case 0:
                    operator = '+';
                    break;
                case 1:
                    operator = '-';
                    break;
                default:
                    operator = '*';
                    number1 = number1 / 2;
                    number2 = number2 / 2;
            }

            var correctAnswer = calculate(number1, number2, operator);
            questions[i] = number1 + " " + operator + " " + number2;
            correctAnswers[i] = Integer.toString(correctAnswer);
        }

        Engine.play(rules, questions, correctAnswers);
    }
}
