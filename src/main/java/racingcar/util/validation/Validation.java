package racingcar.util.validation;

public class Validation {

    public static void validBlankNames(String inputCarNames) {
        if (inputCarNames.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validInputName(String name, int nameCount) {
        if (5 < name.length()) {
            throw new IllegalArgumentException();
        }
        if (name.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        if (nameCount != 1) {
            throw new IllegalArgumentException();
        }
    }

    public static String validCount(String inputCount) {
        if (inputCount.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (!inputCount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(inputCount) < 1) {
            throw new IllegalArgumentException();
        }
        return inputCount;
    }

}
