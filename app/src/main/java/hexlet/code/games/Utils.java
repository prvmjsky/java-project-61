package hexlet.code.games;

import java.util.Random;

public final class Utils {
    private static final Random RANDOMIZER = new Random();

    public static int getRandomNumber(int lowerBound, int upperBound) {
        return RANDOMIZER.nextInt(lowerBound, upperBound);
    }

    public static int getRandomNumber(int bound) {
        return RANDOMIZER.nextInt(bound);
    }
}
