package domain;

import domain.time.DefaultTimeSet;

public class Menu {

    private String name;

    private Integer price;

    private DefaultTimeSet timeSet;

    public Menu(String name, Integer price, DefaultTimeSet timeSet) {
        this.name = name;
        this.price = price;
        this.timeSet = timeSet;
    }

    public Menu() {
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public DefaultTimeSet getTimeSet() {
        return timeSet;
    }
}
