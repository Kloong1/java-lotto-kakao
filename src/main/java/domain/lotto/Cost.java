package domain.lotto;

public class Cost {

    public static final int MINIMUM_VALUE = 0;

    private final int cost;

    public Cost(int cost) {
        validateRange(cost);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int countAvailablePurchases(int price) {
        return cost / price;
    }

    private void validateRange(int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException("잘못된 범위의 숫자입니다.");
        }
    }
}
