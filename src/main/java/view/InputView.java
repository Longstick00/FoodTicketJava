package view;

import java.util.Scanner;

public class InputView {

    public InputView() {
    }

    public String getAccountId() {
        System.out.println(ConsoleMessage.INPUT_ACCOUNT_ID.message);
        return getInput();
    }

    public String getRestaurantName() {
        System.out.println(ConsoleMessage.CHOOSE_RESTAURANT.message);
        return getInput();
    }

    public String getMenuName() {
        System.out.println(ConsoleMessage.CHOOSE_MENU.message);
        return getInput();
    }

    public String getServiceNumber() {
        System.out.print(ConsoleMessage.SELECT_PROCESS.message);
        return getInput();
    }

    public String getAccountInfo() {
        System.out.println(ConsoleMessage.MAKE_NEW_USER.message);
        return getInput();
    }

    public String getTimeSet() {
        System.out.println(ConsoleMessage.SELECT_TIMESET.message);
        return getInput();
    }

    public String getTimeType() {
        System.out.println(ConsoleMessage.SELECT_TIME_TYPE.message);
        return getInput();
    }

    public String getCorrectionTime() {
        System.out.println(ConsoleMessage.INPUT_TIME.message);
        return getInput();
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private enum ConsoleMessage {
        INPUT_ACCOUNT_ID("유저 ID를 입력해주세요.(ex. Longstick0)"),
        CHOOSE_RESTAURANT("이용하실 식당의 이름 혹은 번호를 선택해주세요.(ex. 1, 2 or 기사식당, 맥도날드..)"),
        CHOOSE_MENU("식사하실 메뉴를 선택해주세요.(ex. 제육덮밥, 오징어덮밥..)"),
        SELECT_PROCESS("""
                관리자 서비스를 시작합니다.
                사용하실 서비스를 선택해주세요.
                1. 유저 추가
                2. 시간대 변경
                3. 관리자 서비스 종료
                4. 프로그램 종료
                """),
        MAKE_NEW_USER("추가하실 유저 이름을 입력해주세요."),
        SELECT_TIMESET("변경하실 시간대를 입력해주세요.(ex. DINNER)"),
        SELECT_TIME_TYPE("시작시각과 종료시각 중 하나를 선택해주세요."),
        INPUT_TIME("변경하실 시각을 입력해주세요.(ex. 10:00)");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }

    }

}
