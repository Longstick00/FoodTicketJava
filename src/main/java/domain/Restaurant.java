package domain;

import java.util.List;

public class Restaurant {

    private Long restaurantId;
    private String name;
    private List<Menu> menuList;

    public Restaurant(Long id, String name, List<Menu> menuList) {
        this.restaurantId = id;
        this.name = name;
        this.menuList = menuList;
    }

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
}
