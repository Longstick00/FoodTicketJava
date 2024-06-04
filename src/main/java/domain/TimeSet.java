package domain;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.NoSuchElementException;

public enum TimeSet {
    BREAKFAST(LocalTime.of(6, 0), LocalTime.of(10, 59)),
    LAUNCH(LocalTime.of(11, 0), LocalTime.of(17, 59)),
    DINNER(LocalTime.of(18, 0), LocalTime.of(22, 59));

    private final LocalTime start;
    private final LocalTime finish;

    TimeSet(LocalTime start, LocalTime finish) {
        this.start = start;
        this.finish = finish;
    }

    public static TimeSet getTimeSet() {
        LocalTime now = LocalTime.now();
        return Arrays.stream(TimeSet.values())
                .filter(t -> t.start.isBefore(now) && t.finish.isAfter(now))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("현재 주문 가능한 메뉴가 없거나 가게가 운영중이지 않습니다."));
    }

}
