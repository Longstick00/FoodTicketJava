package view;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    public void getAccountId() {
        System.out.println(ConsoleMessage.INPUT_ACCOUNT_ID.message);

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
