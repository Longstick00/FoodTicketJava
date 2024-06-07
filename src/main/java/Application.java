import config.AppConfig;
import service.MainService;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MainService mainService = appConfig.mainService();

        try {
            mainService.runMainService();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
