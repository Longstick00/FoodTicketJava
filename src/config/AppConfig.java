package config;

import service.MainService;
import view.InputConverter;
import view.InputManager;
import view.InputView;
import view.OutputView;

public class AppConfig {

    public MainService mainService() {
        return new MainService(inputManager(), outputView());
    }

    private InputManager inputManager() {
        return new InputManager(inputView(), inputConverter());
    }

    private InputView inputView() {
        return InputView.getInstance();
    }

    private InputConverter inputConverter() {
        return InputConverter.getInstance();
    }

    private OutputView outputView() {
        return OutputView.getInstance();
    }
}
