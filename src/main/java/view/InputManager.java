package view;

import constant.AdminProcess;
import domain.Account;
import domain.Menu;
import domain.Restaurant;
import domain.time.TimeSet;
import domain.time.TimeTable;
import repository.AccountRepository;
import repository.RestaurantRepository;

import java.time.LocalTime;

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

    public Menu getSelectedMenu(final Restaurant restaurant) {
        String menuName = inputView.getMenuName();
        return restaurant.menuSelect(menuName);
    }

    public AdminProcess getAdminProcess() {
        String serviceNumber = inputView.getServiceNumber();
        Integer adminProcessNum = inputValidation.stringToInt(serviceNumber);
        return AdminProcess.getProcessNumByValue(adminProcessNum);
    }

    public Account getNewAccount() {
        String accountInfo = inputView.getAccountInfo();
        inputValidation.checkBlank(accountInfo);
        return new Account(accountInfo);
    }

    public TimeSet getCorrectionTimeSet(final TimeTable timeTable) {
        String timeSet = inputView.getTimeSet();
        return timeTable.findTimeRange(timeSet);
    }

    public String getSelectedTimeType() {
        String timeType = inputView.getTimeType();
        inputValidation.checkTimeType(timeType);
        return timeType;
    }

    public LocalTime getCorrectionTime() {
        String correctionTime = inputView.getCorrectionTime();
        String[] split = correctionTime.split(":");
        inputValidation.checkTime(split);
        return LocalTime.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}
