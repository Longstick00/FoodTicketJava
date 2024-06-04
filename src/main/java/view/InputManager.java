package view;

import domain.Account;

public class InputManager {

    private final InputView inputView;
    private final InputValidation inputValidation;

    public InputManager(InputView inputView, InputValidation inputValidation) {
        this.inputView = inputView;
        this.inputValidation = inputValidation;
    }

    public Account getAccountId() {
        String accountId = inputView.getAccountId();
        inputValidation.checkBlank(accountId);
        return new Account(accountId);
    }

    public String getRestaurantName() {
        return inputView.getRestaurantName();
    }
}
