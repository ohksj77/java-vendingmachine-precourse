package vendingmachine.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public String readOwningMoney() {
        final String input = Console.readLine();
        inputValidator.validateNumeric(input);
        return input;
    }
}