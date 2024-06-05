package domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public class TimeRange {

    @JsonFormat(pattern = "kk:mm")
    private LocalTime start;

    @JsonFormat(pattern = "kk:mm")
    private LocalTime end;

    private TimeSet timeSet;

    public TimeRange() {
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public TimeSet getTimeSet() {
        return timeSet;
    }
}
