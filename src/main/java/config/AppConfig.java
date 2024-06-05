package config;

import service.MainService;
import view.*;

public class AppConfig {

    public MainService mainService() {
        return new MainService(inputManager(), outputView());
    }

    private InputManager inputManager() {
        return new InputManager(inputView(), inputValidation());
    }

    private InputView inputView() {
        return new InputView();
    }

    private InputValidation inputValidation() {
        return InputValidation.getInstance();
    }

    private OutputView outputView() {
        return OutputView.getInstance();
    }

}
