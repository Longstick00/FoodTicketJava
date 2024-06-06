package domain.time;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class TimeTable {

    private final List<TimeRange> timeRanges;

    public static TimeTable defaultTimeTable() {
         return new TimeTable(Arrays.stream(DefaultTimeSet.values())
                 .map(set ->
                         new TimeRange(set.getStart(), set.getFinish(), TimeSet.valueOf(set.name()))
                 ).toList());
    }

    private TimeTable(List<TimeRange> timeRanges) {
        this.timeRanges = timeRanges;
    }

    public static DefaultTimeSet getTimeSet() {
        LocalTime now = LocalTime.now();
        return Arrays.stream(DefaultTimeSet.values())
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("현재 주문 가능한 메뉴가 없거나 가게가 운영중이지 않습니다."));
    }

    public List<TimeRange> getTimeRanges() {
        return timeRanges;
    }
}
