package domain;

public class Account {

    private String name;
    private Long balance;

    public Account() {
    }

    public Account(String name) {
        this.name = name;
        this.balance = 100000L;
    }

    public Long eat(Integer price) {
        balance -= price;
        return this.balance;
    }

    public String getName() {
        return this.name;
    }

    public Long getBalance() {
        return balance;
    }
}
