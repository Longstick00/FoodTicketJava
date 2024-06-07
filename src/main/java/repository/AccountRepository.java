package repository;

import domain.Account;
import util.JsonConverter;

import java.util.List;

public class AccountRepository {
    private static final String FILE_NAME = "account.json";

    private static List<Account> accounts;

    static {
        init();
    }

    public static Account getById(final String accountId) {
        reload();
        return accounts.stream()
                .filter(a -> a.getName().equals(accountId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 ID가 없습니다. 다시 입력해주세요."));
    }

    public static void checkDuplicate(final String accountId) {
        boolean isDuplicate = accounts.stream()
                .anyMatch(account -> account.getName().equals(accountId));
        if (isDuplicate) {
            throw new IllegalArgumentException("이름(ID)이 중복됩니다. 다른 이름을 작성해주세요.");
        }
    }

    private static void init() {
        accounts = JsonConverter.jsonToEntity(Account.class, FILE_NAME);
    }

    private static void reload() {
        init();
    }
}
