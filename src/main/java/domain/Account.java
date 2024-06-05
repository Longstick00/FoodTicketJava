package domain;

public class Account {

    private String name;

    private Long balance;

    private Role role;

    public Account() {
    }

    public Account(String name) {
        this.name = name;
        this.balance = 100000L;
        this.role = Role.GENERAL;
    }

    public Long pay(Integer price) {
        checkNegative(price);
        balance -= price;
        return this.balance;
    }

    private void checkNegative(Integer price) {
        if (this.balance - price < 0) {
            throw new IllegalStateException("잔액이 부족합니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public Long getBalance() {
        return balance;
    }

    public Role getRole() {
        return role;
    }
}
