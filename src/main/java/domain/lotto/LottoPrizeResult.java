package domain.lotto;

import service.LottoShop;

import java.util.Map;
import java.util.Objects;

public class LottoPrizeResult {

    private final Map<LottoPrize, Integer> prizeCounts;

    public LottoPrizeResult(Map<LottoPrize, Integer> prizeCounts) {
        validatePrizeCounts(prizeCounts);
        this.prizeCounts = prizeCounts;
    }

    public Map<LottoPrize, Integer> getPrizeCounts() {
        return prizeCounts;
    }

    public LottoEarningRate calculateEarningRate(int lottoPurchaseCount) {
        validateLottoPurchaseCount(lottoPurchaseCount);
        double cost = (double) lottoPurchaseCount * LottoShop.LOTTO_PRICE;
        return new LottoEarningRate(calculatePrizeMoneySum() / cost);
    }

    public int calculatePrizeMoneySum() {
        return prizeCounts.entrySet().stream()
                .mapToInt(prizeCount -> prizeCount.getKey().getPrizeMoney() * prizeCount.getValue())
                .sum();
    }

    private void validatePrizeCounts(Map<LottoPrize, Integer> prizeCounts) {
        if (prizeCounts.size() != LottoPrize.values().length) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoPurchaseCount(int lottoPurchaseCount) {
        if (lottoPurchaseCount <= 0) {
            throw new IllegalArgumentException("로또 구매 횟수는 1 이상이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrizeResult that = (LottoPrizeResult) o;
        return Objects.equals(prizeCounts, that.prizeCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeCounts);
    }
}
