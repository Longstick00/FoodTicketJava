import config.AppConfig;
import service.MainService;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MainService mainService = appConfig.mainService();

        mainService.runService();
    }
}
