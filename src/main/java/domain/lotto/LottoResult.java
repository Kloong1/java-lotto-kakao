package domain.lotto;

import java.util.Map;

public class LottoResult {

    private final Map<LottoPrize, Integer> prizeCounts;
    private final double earningRate;

    public LottoResult(Map<LottoPrize, Integer> prizeCounts, double earningRate) {
        this.prizeCounts = prizeCounts;
        this.earningRate = earningRate;
    }
}
