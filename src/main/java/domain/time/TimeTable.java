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

    private TimeTable(final List<TimeRange> timeRanges) {
        this.timeRanges = timeRanges;
    }

    public TimeSet findTimeRange(final String timeSet) {
        TimeRange range = timeRanges.stream()
                .filter(set -> set.getTimeSet().name().equals(timeSet))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("시간대 입력값을 다시 확인해주세요."));
        return range.getTimeSet();
    }

    public TimeSet findTimeSet(final LocalTime now) {
        return timeRanges.stream()
                .filter(range -> range.findNowTimeSet(now))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("현재 시간대에 주문 가능한 메뉴가 없습니다.")).getTimeSet();
    }

    public void checkTimeTable(final TimeSet timeSet,
                               final String timeType,
                               final LocalTime time) {
        int index = timeSet.ordinal();
        TimeRange currentRange = timeRanges.get(index);

        if (timeType.equals("시작시간")) {
            LocalTime endTime = currentRange.getEnd();

            // 이전 시간대의 종료시간과 겹치는지 확인
            if (index > 0) {
                LocalTime previousEndTime = timeRanges.get(index - 1).getEnd();
                if (time.isBefore(previousEndTime) || time.equals(previousEndTime)) {
                    throw new IllegalArgumentException("새 시작 시간이 이전 시간대의 종료 시간과 겹칩니다.");
                }
            }

            // 현재 시간대의 종료시간보다 빠른지 확인
            if (time.isAfter(endTime) || time.equals(endTime)) {
                throw new IllegalArgumentException("시작 시간은 종료 시간보다 빠를 수 없습니다.");
            }

        } else if (timeType.equals("종료시간")) {
            LocalTime startTime = currentRange.getStart();

            // 다음 시간대의 시작시간과 겹치는지 확인
            if (index < timeRanges.size() - 1) {
                LocalTime nextStartTime = timeRanges.get(index + 1).getStart();
                if (time.isAfter(nextStartTime) || time.equals(nextStartTime)) {
                    throw new IllegalArgumentException("새 종료 시간이 다음 시간대의 시작 시간과 겹칩니다.");
                }
            }

            // 현재 시간대의 시작시간보다 늦은지 확인
            if (time.isBefore(startTime) || time.equals(startTime)) {
                throw new IllegalArgumentException("종료 시간은 시작 시간보다 늦을 수 없습니다.");
            }
        }
    }

    public List<TimeRange> getTimeRanges() {
        return timeRanges;
    }

}
