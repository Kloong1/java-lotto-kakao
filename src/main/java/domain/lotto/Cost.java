package domain.lotto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost1 = (Cost) o;
        return cost == cost1.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost);
    }
}
