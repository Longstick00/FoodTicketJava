package view;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        instance.printWelcomeMessage();
        return instance;
    }

    public void printWelcomeMessage() {
        System.out.println(ConsoleMessage.WELCOME.message);
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
