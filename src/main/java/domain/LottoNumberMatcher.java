package domain;

import domain.lotto.LottoPrize;
import domain.lotto.LottoTicket;
import domain.lotto.LottoWinningNumber;

import java.util.Arrays;

public class LottoNumberMatcher {
    private final LottoWinningNumber lottoWinningNumber;

    public LottoNumberMatcher(LottoWinningNumber lottoWinningNumber) {
        this.lottoWinningNumber = lottoWinningNumber;
    }

    public LottoPrize match(LottoTicket lottoTicket) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.prizeJudgment.judge(lottoTicket, lottoWinningNumber))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
}
