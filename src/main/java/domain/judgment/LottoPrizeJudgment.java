package domain.judgment;

import domain.lotto.LottoTicket;
import domain.lotto.LottoWinningNumber;

public interface LottoPrizeJudgment {

    boolean judge(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber);
}
