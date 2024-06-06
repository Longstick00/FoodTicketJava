package view;

public class InputValidation {

    private static final InputValidation instance = new InputValidation();

    public static InputValidation getInstance() {
        return instance;
    }

    public void checkBlank(String input) {
        int before = input.length();
        int after = input.replaceAll(" ", "").length();
        if (before != after) {
            throw new IllegalArgumentException("공백을 제거해주세요");
        }
    }

    public Integer stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값을 다시 확인해주세요.");
        }
    }

    public void checkTimeType(String input) {
        if(!input.equals("시작시간") && !input.equals("종료시간")) throw new IllegalArgumentException("입력값을 다시 확인해주세요. (ex. 시작시간, 종료시간)");
    }
}
