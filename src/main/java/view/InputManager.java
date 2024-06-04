package view;

import domain.Account;
import domain.Restaurant;
import repository.AccountRepository;

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
        return AccountRepository.getById(accountId);
    }

    public Restaurant getSelectedRestaurant() {
        String restaurantName = inputView.getRestaurantName();
        return null;
    }

    public String getSelectedMenu() {
        return inputView.getMenuName();
    }
}
