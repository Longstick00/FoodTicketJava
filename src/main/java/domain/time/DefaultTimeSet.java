package domain.time;

import java.time.LocalTime;

public enum DefaultTimeSet {
    BREAKFAST(LocalTime.of(6, 0), LocalTime.of(10, 59)),
    LAUNCH(LocalTime.of(11, 0), LocalTime.of(17, 59)),
    DINNER(LocalTime.of(18, 0), LocalTime.of(22, 59));

    private final LocalTime start;
    private final LocalTime finish;

    DefaultTimeSet(LocalTime start, LocalTime finish) {
        this.start = start;
        this.finish = finish;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getFinish() {
        return finish;
    }
}
