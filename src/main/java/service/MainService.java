package service;

import constant.AdminProcess;
import domain.Account;
import domain.Menu;
import domain.Restaurant;
import domain.Role;
import domain.time.DefaultTimeSet;
import domain.time.TimeRange;
import domain.time.TimeSet;
import domain.time.TimeTable;
import repository.RestaurantRepository;
import util.ExceptionHandler;
import util.JsonConverter;
import view.InputManager;
import view.OutputView;

import java.time.LocalTime;
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
        if (userAccount.getRole().equals(Role.ADMIN)) {
            adminService(userAccount);
        }
        if (userAccount.getRole().equals(Role.GENERAL)) {
            orderService(userAccount);
        }
    }

    private void adminService(Account userAccount) {
        AdminProcess adminProcess = inputManager.getAdminProcess();

        switch (adminProcess) {
            case NEW_USER -> {
                makeAccount();
            }
            case CHANGE_TIME_SET -> {
                List<Restaurant> restaurants = RestaurantRepository.get();
                Restaurant restaurant = restaurants.stream()
                        .filter(r -> r.isAdmin(userAccount.getName()))
                        .findFirst().get();

                outputView.printTimeTable(restaurant.getTimeTable());
                TimeSet timeSet = ExceptionHandler.handle(inputManager::getCorrectionTimeSet, restaurant.getTimeTable());
                String timeType = ExceptionHandler.handle(inputManager::getSelectedTimeType);
                LocalTime time = ExceptionHandler.handle(inputManager::getCorrectionTime);

                restaurant.updateTimeTable(timeSet, timeType, time);
                System.out.println("변경 완료");
            }
            case RESTART -> {
            }
            case EXIT -> {
                return;
            }
        }
        runMainService();
    }

    private void checkAuth(Account userAccount) {

    }

    private void changeTime(Restaurant restaurant) {

    }

    private void makeAccount() {
        Account newAccount = inputManager.getNewAccount();
        JsonConverter.entityToJson(newAccount, "account.json");
        outputView.printComplete(newAccount.getName());
    }

    private void orderService(Account userAccount) {
        Restaurant restaurant = getSelectedRestaurant();

        Menu menu = getSelectedMenu(restaurant);

        payPrice(userAccount, menu);
    }

    private Account getAccount() {
        return ExceptionHandler.handle(inputManager::getAccountId);
    }

    private Restaurant getSelectedRestaurant() {
        outputView.selectRestaurantMessage(RestaurantRepository.get());
        return ExceptionHandler.handle(inputManager::getSelectedRestaurant);
    }

    private Menu getSelectedMenu(final Restaurant restaurant) {
        LocalTime now = LocalTime.now();
        TimeTable timeTable = restaurant.getTimeTable();
        TimeSet nowTimeSet = timeTable.findTimeSet(now);

        List<Menu> menuListByTimeSet = restaurant.getMenuByTimeOfDay(nowTimeSet);
        outputView.currentTimeMessage(nowTimeSet);
        outputView.selectMenuMessage(menuListByTimeSet);

        return ExceptionHandler.handle(inputManager::getSelectedMenu, restaurant);
    }

    private void payPrice(Account userAccount, Menu menu) {
        Long afterBalance = userAccount.pay(menu.getPrice());
        outputView.payMessage(menu.getPrice(), afterBalance);
    }
}
