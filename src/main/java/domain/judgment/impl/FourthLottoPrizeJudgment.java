package domain.judgment.impl;

import domain.judgment.LottoPrizeJudgment;
import domain.lotto.LottoNumbers;
import domain.lotto.LottoWinningNumber;

public class FourthLottoPrizeJudgment implements LottoPrizeJudgment {

    @Override
    public boolean judge(LottoNumbers lottoNumbers, LottoWinningNumber lottoWinningNumber) {
        LottoNumbers winningNumbers = lottoWinningNumber.getLottoNumbers();
        return lottoNumbers.countCommonLottoNumbers(winningNumbers) == 4;
    }
}
