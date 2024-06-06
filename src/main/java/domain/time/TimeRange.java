package domain.time;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public class TimeRange {

    @JsonFormat(pattern = "kk:mm")
    private LocalTime start;

    @JsonFormat(pattern = "kk:mm")
    private LocalTime end;

    private TimeSet timeSet;

    public TimeRange(LocalTime start, LocalTime end, TimeSet timeSet) {
        this.start = start;
        this.end = end;
        this.timeSet = timeSet;
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
