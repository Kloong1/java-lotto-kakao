package domain.lotto;

import java.util.Arrays;
import java.util.Map;

public class LottoResult {

    private final Map<LottoPrize, Integer> prizeCounts;
    private double earningRate;

    public LottoResult(Map<LottoPrize, Integer> prizeCounts) {
        validatePrizeCounts(prizeCounts);
        this.prizeCounts = prizeCounts;
    }

    public LottoResult(Map<LottoPrize, Integer> prizeCounts, double earningRate) {
        this(prizeCounts);
        this.earningRate = earningRate;
    }

    public Map<LottoPrize, Integer> getPrizeCounts() {
        return prizeCounts;
    }

    public double getEarningRate() {
        return earningRate;
    }

    private void validatePrizeCounts(Map<LottoPrize, Integer> prizeCounts) {
        boolean hasMissingPrize = Arrays.stream(LottoPrize.values())
                .anyMatch(lottoPrize -> !prizeCounts.containsKey(lottoPrize));
        if (hasMissingPrize) {
            throw new IllegalArgumentException();
        }
    }
}
