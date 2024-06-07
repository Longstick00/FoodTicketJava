package domain.time;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public class TimeRange {

    @JsonFormat(pattern = "kk:mm")
    private LocalTime start;

    @JsonFormat(pattern = "kk:mm")
    private LocalTime end;

    private final TimeSet timeSet;

    public TimeRange(final LocalTime start,
                     final LocalTime end,
                     final TimeSet timeSet) {
        this.start = start;
        this.end = end;
        this.timeSet = timeSet;
    }

    public void updateTime(final String timeType, final LocalTime time) {
        if (timeType.equals("시작시간")) {
            start = time;
        }
        if (timeType.equals("종료시간")) {
            end = time;
        }
    }

    public boolean findNowTimeSet(final LocalTime now) {
        return start.isBefore(now) && end.isAfter(now);
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
