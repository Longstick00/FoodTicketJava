package domain;

public class Account {

    private final String name;
    private Long balance;

    public Account(String name, Long balance) {
        this.name = name;
        this.balance = balance;
    }
}
