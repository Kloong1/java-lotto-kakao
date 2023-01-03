package domain.lotto;

import java.util.Arrays;
import java.util.Map;

public class LottoPrizeResult {

    private final Map<LottoPrize, Integer> prizeCounts;
    private double earningRate;

    public LottoPrizeResult(Map<LottoPrize, Integer> prizeCounts) {
        validatePrizeCounts(prizeCounts);
        this.prizeCounts = prizeCounts;
    }

    public LottoPrizeResult(Map<LottoPrize, Integer> prizeCounts, double earningRate) {
        this(prizeCounts);
        this.earningRate = earningRate;
    }

    public Map<LottoPrize, Integer> getPrizeCounts() {
        return prizeCounts;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public LottoEarningRate calculateEarningRate(int lottoPurchaseCount) {
        validateLottoPurchaseCount(lottoPurchaseCount);
        double cost = (double) lottoPurchaseCount * LottoShop.LOTTO_PRICE;
        return new LottoEarningRate(getPrizeMoneySum() / cost);
    }

    private void validateLottoPurchaseCount(int lottoPurchaseCount) {
        if (lottoPurchaseCount <= 0) {
            throw new IllegalArgumentException("로또 구매 횟수는 1 이상이어야 합니다.");
        }
    }

    private int getPrizeMoneySum() {
        return prizeCounts.entrySet().stream()
                .mapToInt(prizeCount -> prizeCount.getKey().getPrizeMoney() * prizeCount.getValue())
                .sum();
    }

    private void validatePrizeCounts(Map<LottoPrize, Integer> prizeCounts) {
        boolean hasMissingPrize = Arrays.stream(LottoPrize.values())
                .anyMatch(lottoPrize -> !prizeCounts.containsKey(lottoPrize));
        if (hasMissingPrize) {
            throw new IllegalArgumentException();
        }
    }
}
