package FLSStatisticEmulator.service;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NameGenerator {

    private static final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    private static final String DIGIT = "0123456789";

    private static final int NAME_LENGTH = 6;

    private static final String NAME_ALLOW = CHAR_LOWERCASE + DIGIT;

    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        generateName();
    }

    public static String generateName() {

        StringBuilder result = new StringBuilder(NAME_LENGTH);

        String strLowerCase = generateRandomString(CHAR_LOWERCASE);
        result.append(strLowerCase);

        String strDigit = generateRandomString(DIGIT);
        result.append(strDigit);

        String strOther = generateRandomString(NAME_ALLOW);
        result.append(strOther);

        String password = result.toString();

        return shuffleString(password);
    }

    private static String generateRandomString(String input) {

        if (input == null || input.length() <= 0)
            throw new IllegalArgumentException("Invalid input.");

        StringBuilder result = new StringBuilder(2);
        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(input.length());
            result.append(input.charAt(index));
        }
        return result.toString();
    }

    public static String shuffleString(String input) {
        List<String> result = Arrays.asList(input.split(""));
        Collections.shuffle(result);
        return String.join("", result);
    }
}