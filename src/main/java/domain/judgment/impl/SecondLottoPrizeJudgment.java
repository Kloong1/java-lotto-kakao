package domain.judgment.impl;

import domain.judgment.LottoPrizeJudgment;
import domain.lotto.LottoNumber;
import domain.lotto.LottoNumbers;
import domain.lotto.LottoWinningNumber;

public class SecondLottoPrizeJudgment implements LottoPrizeJudgment {

    @Override
    public boolean judge(LottoNumbers lottoNumbers, LottoWinningNumber lottoWinningNumber) {
        LottoNumbers winningNumbers = lottoWinningNumber.getLottoNumbers();
        LottoNumber bonusNumber = lottoWinningNumber.getBonusNumber();
        return lottoNumbers.countCommonLottoNumbers(winningNumbers) == 5 && lottoNumbers.contains(bonusNumber);
    }
}
