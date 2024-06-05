package service;

import constant.AdminProcess;
import domain.*;
import repository.RestaurantRepository;
import util.ExceptionHandler;
import util.JsonConverter;
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
        if (userAccount.getRole().equals(Role.ADMIN)) {
            adminService(userAccount);
        }
        if (userAccount.getRole().equals(Role.GENERAL)) {
            orderService(userAccount);
        }
    }

    private void adminService(Account userAccount) {
        outputView.startAdminServiceMessage();
        AdminProcess adminProcess = inputManager.getAdminProcess();

        switch (adminProcess) {
            case NEW_USER -> {
                makeAccount();
            }
            case CHANGE_TIME_SET -> {

            }
            case EXIT -> {

            }

        }
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
        TimeSet nowTimeSet = TimeSet.getTimeSet();

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
