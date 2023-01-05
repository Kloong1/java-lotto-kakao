package domain.judgment;

import domain.lotto.LottoNumbers;
import domain.lotto.LottoWinningNumber;

public interface LottoPrizeJudgment {

    boolean judge(LottoNumbers lottoNumbers, LottoWinningNumber lottoWinningNumber);
}
