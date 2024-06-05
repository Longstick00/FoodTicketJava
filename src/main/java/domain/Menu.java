package domain;

public class Menu {

    private String name;

    private Integer price;

    private TimeSet timeSet;

    public Menu(String name, Integer price, TimeSet timeSet) {
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

    public TimeSet getTimeSet() {
        return timeSet;
    }
}
