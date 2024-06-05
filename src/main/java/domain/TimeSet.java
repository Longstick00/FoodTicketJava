package domain;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.NoSuchElementException;

public enum TimeSet {
    BREAKFAST,
    LAUNCH,
    DINNER;

    public static TimeSet getTimeSet() {
        LocalTime now = LocalTime.now();
        return Arrays.stream(TimeSet.values())
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("현재 주문 가능한 메뉴가 없거나 가게가 운영중이지 않습니다."));
    }

}
