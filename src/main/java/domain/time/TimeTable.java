package domain.time;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

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

    public TimeSet findTimeRange(String timeSet) {
        TimeRange range = timeRanges.stream()
                .filter(set -> set.getTimeSet().name().equals(timeSet))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("시간대 입력값을 다시 확인해주세요."));
        return range.getTimeSet();
    }

    public TimeSet findTimeSet(LocalTime now) {
        return timeRanges.stream()
                .filter(range -> range.findNowTimeSet(now))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("현재 시간대에 주문 가능한 메뉴가 없습니다.")).getTimeSet();
    }

    public List<TimeRange> getTimeRanges() {
        return timeRanges;
    }
}
