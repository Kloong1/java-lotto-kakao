package service;

import domain.lotto.LottoPrize;
import domain.lotto.LottoPrizeResult;
import domain.lotto.LottoTicket;
import domain.lotto.LottoWinningNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoPrizeCounter {
    private final LottoWinningNumber lottoWinningNumber;

    public LottoPrizeCounter(LottoWinningNumber lottoWinningNumber) {
        this.lottoWinningNumber = lottoWinningNumber;
    }

    public LottoPrizeResult countPrize(List<LottoTicket> lottoTickets) {
        Map<LottoPrize, Integer> prizeCounts = new HashMap<>();
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> prizeCounts.put(prize, 0));

        lottoTickets.stream()
                .map(lottoTicket -> LottoPrize.matchLottoTicket(lottoTicket, lottoWinningNumber))
                .forEach(lottoPrize -> prizeCounts.computeIfPresent(lottoPrize, (prize, count) -> count + 1));

        return new LottoPrizeResult(prizeCounts);
    }
}
