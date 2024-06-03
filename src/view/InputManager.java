package view;

import domain.Account;
import util.ExceptionHandler;

public class InputManager {

    private final InputView inputView;

    public InputManager(InputView inputView) {
        this.inputView = inputView;
    }

    public Account getAccountId() {
        return ExceptionHandler.handle(inputView::getAccountId);
    }
}
