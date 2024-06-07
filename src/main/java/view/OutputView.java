package view;

import domain.Menu;
import domain.Restaurant;
import domain.time.TimeRange;
import domain.time.TimeSet;
import domain.time.TimeTable;

import java.util.List;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        instance.welcomeMessage();
        return instance;
    }

    public void welcomeMessage() {
        System.out.print(ConsoleMessage.WELCOME.message);
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
        System.out.print(ConsoleMessage.MENU_BAR.message);
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

    public void payMessage(Integer price, Long afterBalance) {
        String format = String.format(ConsoleMessage.AMOUNT.message, price, afterBalance);
        System.out.println(format);
    }

    public void printComplete(String name) {
        String format = String.format(ConsoleMessage.COMPLETE.message, name);
        System.out.println(format);
    }

    public void printTimeTable(TimeTable timeTable) {
        System.out.println(ConsoleMessage.PROGRESS_BAR.message);
        System.out.println(ConsoleMessage.TIME_BAR.message);
        for (TimeRange timeRange : timeTable.getTimeRanges()) {
            String format = String.format(ConsoleMessage.TIMETABLE.message,
                    timeRange.getStart(),
                    timeRange.getEnd(),
                    timeRange.getTimeSet().name()
            );
            System.out.println(format);
        }
        System.out.println(ConsoleMessage.PROGRESS_BAR.message);
    }

    private enum ConsoleMessage {
        WELCOME("""
            =========================================
            |               법틀의                   |
            |               식권대장                 |
            |               서비스                   |
            =========================================
            """),
        NOW_TIME_MESSAGE("현재 %s시간입니다. %s메뉴를 보여드릴게요."),
        AMOUNT("%d원이 결제되었습니다. 남은 잔액은 %d원 입니다. \n" +
                "감사합니다 :)"),
        PROGRESS_BAR("=========================================="),
        MENU_BAR("""
            ==========================================
            |     메뉴     |   가격   |     시간대     |
            ==========================================
            """),
        MENU_PRICE("| %6s | %6d원 | %10s   |"),
        COMPLETE("%s 추가 완료했습니다."),
        TIMETABLE("| %-10s | %-10s | %-10s |"),
        TIME_BAR("| 시작시간    | 종료시간    | 시간대     |");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }

    }

}
