public class LottoNumber {

    public static final int MINIMUM_VALUE = 1;
    public static final int MAXIMUM_VALUE = 45;
    
    private final int value;

    public LottoNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < MINIMUM_VALUE || value > MAXIMUM_VALUE) {
            throw new IllegalArgumentException("잘못된 범위의 숫자입니다.");
        }
    }
}
