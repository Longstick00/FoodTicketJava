package domain;

import java.util.List;

public class Restaurant {

    private final String name;
    private final List<Menu> menuList;

    public Restaurant(String name, List<Menu> menuList) {
        this.name = name;
        this.menuList = menuList;
    }


}
