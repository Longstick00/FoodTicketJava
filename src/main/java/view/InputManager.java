package view;

import domain.Account;
import domain.Menu;
import domain.Restaurant;
import repository.AccountRepository;
import repository.RestaurantRepository;

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
        return RestaurantRepository.getByName(restaurantName);
    }

    public Menu getSelectedMenu(Restaurant restaurant) {
        String menuName = inputView.getMenuName();
        return restaurant.menuSelect(menuName);
    }
}
