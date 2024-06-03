package domain;

public class Account {

    private final String name;
    private Long balance;

    public Account(String name) {
        this.name = name;
        this.balance = 100000L;
    }
}
