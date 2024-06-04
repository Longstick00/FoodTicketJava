package view;

import domain.Restaurant;
import domain.RestaurantList;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        instance.welcomeMessage();
        return instance;
    }

    public void welcomeMessage() {
        System.out.println(ConsoleMessage.WELCOME.message);
    }

    public void selectRestaurantMessage(RestaurantList restaurantList) {
        Integer index = 1;
        for (Restaurant restaurant : restaurantList.restaurants()) {
            String message = String.format("%d. %s", index, restaurant.getName());
            System.out.println(message);
            index++;
        }
    }

    private enum ConsoleMessage {
        WELCOME("""
            =========================================
            |               법틀의                  |
            |               식권대장                 |
            |               서비스                  |
            =========================================
            """),
        AMOUNT("%d원이 결제되었습니다.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }

    }

}
