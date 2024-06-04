package domain;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Menu> getMenuByTimeOfDay(TimeSet timeSet) {
        return menuList.stream()
                .filter(menu -> menu.getTimeSet().equals(timeSet))
                .collect(Collectors.toList());
    }

    public Menu menuSelect(String selectedMenu) {
        return menuList.stream()
                .filter(menu -> menu.getName().equals(selectedMenu))
                .findFirst().get();
    }
}
