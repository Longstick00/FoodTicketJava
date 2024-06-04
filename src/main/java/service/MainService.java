package service;

import domain.Account;
import domain.Menu;
import domain.Restaurant;
import domain.TimeSet;
import repository.RestaurantRepository;
import util.ExceptionHandler;
import util.JsonConverter;
import view.InputManager;
import view.OutputView;

import java.util.List;

public class MainService {

    private final InputManager inputManager;
    private final OutputView outputView;

    public MainService(InputManager inputManager,
                       OutputView outputView) {
        this.inputManager = inputManager;
        this.outputView = outputView;
    }

    public void runService() {
        List<Restaurant> restaurants = RestaurantRepository.get();
        Account userAccount = ExceptionHandler.handle(inputManager::getAccountId);
        outputView.selectRestaurantMessage(RestaurantRepository.get());

        Restaurant restaurant = ExceptionHandler.handle(inputManager::getSelectedRestaurant);

        TimeSet nowTimeSet = TimeSet.getTimeSet();
        List<Menu> menuListByTimeSet = restaurant.getMenuByTimeOfDay(nowTimeSet);
        outputView.currentTimeMessage(nowTimeSet);
        outputView.selectMenuMessage(menuListByTimeSet);
        String selectedMenu = inputManager.getSelectedMenu();

        Menu menu = restaurant.menuSelect(selectedMenu);
        Long afterBalance = userAccount.eat(menu.getPrice());
        outputView.payMessage(menu.getPrice());
    }
}
