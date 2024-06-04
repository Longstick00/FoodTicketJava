package view;

import domain.Menu;
import domain.Restaurant;
import repository.RestaurantRepository;
import domain.TimeSet;

import java.util.List;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        instance.welcomeMessage();
        return instance;
    }

    public void welcomeMessage() {
        System.out.println(ConsoleMessage.WELCOME.message);
    }

    public void selectRestaurantMessage(List<Restaurant> restaurants) {
        Integer index = 1;
        for (Restaurant restaurant : restaurants) {
            String message = String.format("%d. %s", index, restaurant.getName());
            System.out.println(message);
            index++;
        }
    }

    public void selectMenuMessage(List<Menu> restaurant) {
        System.out.println(ConsoleMessage.PROGRESS_BAR.message);
        System.out.println(ConsoleMessage.MENU_BAR.message);
        System.out.println(ConsoleMessage.PROGRESS_BAR.message);
        for (Menu menu : restaurant) {
            String menuInfo = String.format(ConsoleMessage.MENU_PRICE.message, menu.getName(), menu.getPrice(), menu.getTimeSet());
            System.out.println(menuInfo);
        }
        System.out.println(ConsoleMessage.PROGRESS_BAR.message);
    }

    public void currentTimeMessage(TimeSet timeSet) {
        String format = String.format(ConsoleMessage.NOW_TIME_MESSAGE.message, timeSet, timeSet);
        System.out.println(format);
    }

    public void payMessage(Integer price) {
        String format = String.format(ConsoleMessage.AMOUNT.message, price);
        System.out.println(format);
    }

    private enum ConsoleMessage {
        WELCOME("""
            =========================================
            |               법틀의                  |
            |               식권대장                 |
            |               서비스                  |
            =========================================
            """),
        NOW_TIME_MESSAGE("현재 %s시간입니다. %s메뉴를 보여드릴게요."),
        AMOUNT("%d원이 결제되었습니다."),
        PROGRESS_BAR("=========================================="),
        MENU_BAR("|    메뉴    |   가격   |       시간대     |"),
        MENU_PRICE("\"| %10s | %6d원 | %10s     |\"");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }

    }

}
