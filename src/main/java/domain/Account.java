package domain;

public class Account {

    private String name;
    private Long balance;

    public Account() {
    }

    public Long eat(Integer price) {
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
}
