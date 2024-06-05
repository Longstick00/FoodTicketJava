package service;

import domain.Account;
import domain.Menu;
import domain.Restaurant;
import domain.TimeSet;
import repository.RestaurantRepository;
import util.ExceptionHandler;
import view.InputManager;
import view.OutputView;

import java.util.List;

public class MainService {

    private final InputManager inputManager;
    private final OutputView outputView;

    public MainService(final InputManager inputManager,
                       final OutputView outputView) {
        this.inputManager = inputManager;
        this.outputView = outputView;
    }

    public void runMainService() {
        Account userAccount = getAccount();

        Restaurant restaurant = getSelectedRestaurant();

        Menu menu = getSelectedMenu(restaurant);

        Long afterBalance = userAccount.eat(menu.getPrice());
        outputView.payMessage(menu.getPrice(), afterBalance);
    }

    private Account getAccount() {
        return ExceptionHandler.handle(inputManager::getAccountId);
    }

    private Restaurant getSelectedRestaurant() {
        outputView.selectRestaurantMessage(RestaurantRepository.get());
        return ExceptionHandler.handle(inputManager::getSelectedRestaurant);
    }

    private Menu getSelectedMenu(final Restaurant restaurant) {
        TimeSet nowTimeSet = TimeSet.getTimeSet();
        List<Menu> menuListByTimeSet = restaurant.getMenuByTimeOfDay(nowTimeSet);
        outputView.currentTimeMessage(nowTimeSet);
        outputView.selectMenuMessage(menuListByTimeSet);
        return ExceptionHandler.handle(inputManager::getSelectedMenu, restaurant);

    }
}
