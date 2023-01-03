package domain.lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    private final List<LottoTicket> lottoTickets;
    private final LottoWinningNumber lottoWinningNumber;

    public LottoResultCalculator(List<LottoTicket> lottoTickets, LottoWinningNumber lottoWinningNumber) {
        this.lottoTickets = lottoTickets;
        this.lottoWinningNumber = lottoWinningNumber;
    }

    public LottoPrizeResult calculateLottoResult() {
        double earningRate = calculateEarningRate();
        Map<LottoPrize, Integer> prizeCounts = countLottoPrize();

        return new LottoPrizeResult(prizeCounts, earningRate);
    }

    private Map<LottoPrize, Integer> countLottoPrize() {
        Map<LottoPrize, Integer> prizeCounts = new HashMap<>();
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> prizeCounts.put(prize, 0));

        lottoTickets.stream()
                .map(lottoTicket -> LottoPrize.findPrize(lottoTicket, lottoWinningNumber))
                .forEach(lottoPrize -> prizeCounts.computeIfPresent(lottoPrize, (key, value) -> value + 1));

        return prizeCounts;
    }

    private double calculateEarningRate() {
        double lottoCost = lottoTickets.size() * LottoShop.LOTTO_PRICE;
        int prizeMoneySum = lottoTickets.stream()
                .map(lottoTicket -> LottoPrize.findPrize(lottoTicket, lottoWinningNumber))
                .mapToInt(LottoPrize::getPrizeMoney)
                .sum();

        return prizeMoneySum / lottoCost;
    }
}