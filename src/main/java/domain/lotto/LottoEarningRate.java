package domain.lotto;

public class LottoEarningRate {
    private final double earningRate;

    public LottoEarningRate(double earningRate) {
        validatePositive(earningRate);
        this.earningRate = earningRate;
    }

    public double getEarningRate() {
        return earningRate;
    }

    private void validatePositive(double earningRate) {
        if (earningRate < 0.0) {
            throw new IllegalArgumentException("수익률은 0 이상이어야 합니다.");
        }
    }
}
