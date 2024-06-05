package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Restaurant {

    private Long id;
    private String name;
    private List<Menu> menuList;

    public Restaurant() {
    }

    public List<Menu> getMenuByTimeOfDay(TimeSet timeSet) {
        return menuList.stream()
                .filter(menu -> menu.getTimeSet().equals(timeSet))
                .collect(Collectors.toList());
    }

    public Menu menuSelect(String selectedMenu) {
        return menuList.stream()
                .filter(menu -> menu.getName().equals(selectedMenu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 메뉴가 없습니다. 다시 선택해주세요."));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
}
