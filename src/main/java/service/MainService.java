package service;

import domain.Account;
import domain.Restaurant;
import domain.RestaurantList;
import domain.TimeSet;
import util.ExceptionHandler;
import util.JsonConverter;
import view.InputManager;
import view.OutputView;

import java.time.LocalDate;
import java.time.LocalTime;

public class MainService {

    private final InputManager inputManager;
    private final OutputView outputView;
    private final JsonConverter jsonConverter;

    public MainService(InputManager inputManager,
                       OutputView outputView,
                       JsonConverter jsonConverter) {
        this.inputManager = inputManager;
        this.outputView = outputView;
        this.jsonConverter = jsonConverter;
    }

    public void runService() {
        RestaurantList restaurantList = jsonConverter.convertToObject();
        Account userAccount = ExceptionHandler.handle(inputManager::getAccountId);
        outputView.selectRestaurantMessage(restaurantList);

        String restaurantName = inputManager.getRestaurantName();
        Restaurant restaurant = restaurantList.restaurants().stream()
                .filter(o -> o.getName().equals(restaurantName))
                .findFirst().get();

        TimeSet timeSet = TimeSet.getTimeSet();
        System.out.println(LocalTime.now() + timeSet.name());

    }
}
