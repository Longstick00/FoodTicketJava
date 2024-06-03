package service;

import view.InputManager;
import view.OutputView;

public class MainService {

    private final InputManager inputManager;
    private final OutputView outputView;

    public MainService(InputManager inputManager, OutputView outputView) {
        this.inputManager = inputManager;
        this.outputView = outputView;
    }

    public void runService() {
        inputManager.getAccountId();
    }
}
