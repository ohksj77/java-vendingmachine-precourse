package vendingmachine.io;

import vendingmachine.constant.ErrorMessage;

public class InputValidator {

    private static final Character MIN_NUMBER_STANDARD = '0';
    private static final Character MAX_NUMBER_STANDARD = '9';

    public void validateNumeric(final String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getMessage());
        }
    }

    private boolean isNotNumeric(final String input) {
        return input.chars().anyMatch(c -> c < MIN_NUMBER_STANDARD || c > MAX_NUMBER_STANDARD);
    }

    public void validateProducts(final String input) {
        if (isInvalidProductsInput(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRODUCTS_INPUT.getMessage());
        }
    }

    private boolean isInvalidProductsInput(final String input) {
        return !input.startsWith("[") || !input.endsWith("]") || !input.contains(",");
    }
}
