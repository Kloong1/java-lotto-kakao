public class Cost {

    public static final int MINIMUM_VALUE = 1;

    private final int value;

    public Cost(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException("잘못된 범위의 숫자입니다.");
        }
    }
}
