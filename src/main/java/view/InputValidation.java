package view;

public class InputValidation {

    public static InputValidation create() {
        return new InputValidation();
    }

    private InputValidation() {
    }

    public void checkBlank(final String input) {
        int before = input.length();
        int after = input.replaceAll(" ", "").length();
        if (before != after) {
            throw new IllegalArgumentException("공백을 제거해주세요");
        }
    }

    public Integer stringToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값을 다시 확인해주세요.");
        }
    }

    public void checkTimeType(final String input) {
        if(!input.equals("시작시간") && !input.equals("종료시간")) throw new IllegalArgumentException("입력값을 다시 확인해주세요. (ex. 시작시간, 종료시간)");
    }

    public void checkTime(final String[] split) {
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        if (hour > 23 || hour < 0) {
            throw new IllegalArgumentException("입력값 시간(hour)을 확인해주세요.");
        }
        if (min > 59 || min < 0) {
            throw new IllegalArgumentException("입력값 분(minute)을 확인해주세요.");
        }
    }
}
