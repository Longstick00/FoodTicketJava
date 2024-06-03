package domain;

import java.time.LocalTime;

public enum TimeSet {
    BREAKFAST(LocalTime.of(8, 0)),
    LAUNCH(LocalTime.of(12, 0)),
    DINNER(LocalTime.of(18, 0)),;

    private final LocalTime timeLimit;

    TimeSet(LocalTime timeLimit) {
        this.timeLimit = timeLimit;
    }
}
