package controller;

import service.AdminService;
import service.MainService;

public class MainController {

    private final AdminService adminService;
    private final MainService mainService;

    public MainController(AdminService adminService, MainService mainService) {
        this.adminService = adminService;
        this.mainService = mainService;
    }
}
