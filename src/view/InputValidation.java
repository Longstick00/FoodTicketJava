package view;

public class InputValidation {

    private static final InputValidation instance = new InputValidation();

    public static InputValidation getInstance() {
        return instance;
    }

    public void checkBlank(String input) {
        int before = input.length();
        int after = input.trim().length();
        if (before != after) {
            throw new IllegalArgumentException("공백을 제거해주세요");
        }
    }
}
