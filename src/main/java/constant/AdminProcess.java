package constant;

import java.util.stream.Stream;

public enum AdminProcess {
    NEW_USER(1), CHANGE_TIME_SET(2), RESTART(3) ,EXIT(4);

    private final Integer num;

    AdminProcess(final Integer num) {
        this.num = num;
    }

    public static AdminProcess getProcessNumByValue(final Integer value) {
        return Stream.of(values())
                .filter(n -> n.num.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력값을 다시 확인해주세요."));
    }
}
