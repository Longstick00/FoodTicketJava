package domain;

import java.util.List;

public class Restaurant {

    private Long id;

    private String name;

    private List<Menu> menuList;

    private Account admin;

    private TimeTable timeTable;

    public Restaurant() {
    }

    public List<Menu> getMenuByTimeOfDay(TimeSet timeSet) {
        List<Menu> filterMenuList = menuList.stream()
                .filter(menu -> menu.getTimeSet().equals(timeSet))
                .toList();
        if (filterMenuList.isEmpty()) {
            throw new IllegalStateException("현재 시간에 판매할 수 있는 메뉴가 없습니다. 다른 시간에 이용해주세요.");
        }
        return filterMenuList;
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

    public Account getAdmin() {
        return admin;
    }

    public TimeTable getTimeTable() {
        return timeTable;
    }
}
