package hexlet.code.games;

public class Calc {
    private static final int RANDOM_NUMBER_BOUND = 50;

    private static Integer calculate(int number1, int number2, char operator) {
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
        Character[] operators = {'+', '-', '*'};

        for (var i = 0; i < Engine.FINAL_ROUND; i++) {
            var number1 = Utils.getRandomNumber(RANDOM_NUMBER_BOUND);
            var number2 = Utils.getRandomNumber(RANDOM_NUMBER_BOUND);
            char operator = operators[Utils.getRandomNumber(operators.length)];

            if (operator == '*') {
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
