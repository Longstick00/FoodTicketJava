package config;

import service.MainService;
import view.InputManager;
import view.InputValidation;
import view.InputView;
import view.OutputView;

public class AppConfig {

    public MainService mainService() {
        return new MainService(inputManager(), outputView());
    }

    private InputManager inputManager() {
        return new InputManager(inputView(), inputValidation());
    }

    private InputView inputView() {
        return InputView.create();
    }

    private InputValidation inputValidation() {
        return InputValidation.create();
    }

    private OutputView outputView() {
        return OutputView.create();
    }
}
