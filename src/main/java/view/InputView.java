package view;

import domain.Account;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
    }

    public String getAccountId() {
        System.out.println(ConsoleMessage.INPUT_ACCOUNT_ID.message);
        return getInput();
    }

    public String getRestaurantName() {
        System.out.println(ConsoleMessage.INPUT_ACCOUNT_ID.message);
        return getInput();
    }

    public String getMenuName() {
        System.out.println(ConsoleMessage.CHOOSE_MENU.message);
        return getInput();
    }

    private String getInput() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    private enum ConsoleMessage {
        INPUT_ACCOUNT_ID("유저 ID를 입력해주세요.(ex. Longstick0)"),
        CHOOSE_RESTAURANT("이용하실 식당을 선택해주세요.(ex. 기사식당, 맥도날드..)"),
        CHOOSE_MENU("식사하실 메뉴를 선택해주세요.(ex. 제육덮밥, 오징어덮밥..)");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }

    }

}
