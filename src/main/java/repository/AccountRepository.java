package repository;

import domain.Account;
import util.JsonConverter;

import java.util.List;

public class AccountRepository {

    private static final List<Account> accounts =
            JsonConverter.jsonToEntity(Account.class, "account.json");

    public static Account getById(String accountId) {
        return accounts.stream()
                .filter(a -> a.getName().equals(accountId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 ID가 없습니다. 다시 입력해주세요."));
    }

}
