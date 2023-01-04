package domain.lotto;

public class LottoEarningRate {
    public static final double MINIMUM_EARNING_RATE = 0.0;
    private final double earningRate;

    public LottoEarningRate(double earningRate) {
        validatePositive(earningRate);
        this.earningRate = earningRate;
    }

    public double getEarningRate() {
        return earningRate;
    }

    private void validatePositive(double earningRate) {
        if (earningRate < MINIMUM_EARNING_RATE) {
            throw new IllegalArgumentException("수익률은 0 이상이어야 합니다.");
        }
    }
}
