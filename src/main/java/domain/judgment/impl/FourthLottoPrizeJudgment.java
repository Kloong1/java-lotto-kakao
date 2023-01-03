package domain.judgment.impl;

import domain.judgment.LottoPrizeJudgment;
import domain.lotto.LottoNumber;
import domain.lotto.LottoTicket;
import domain.lotto.LottoWinningNumber;
import util.ListUtils;

import java.util.List;

public class FourthLottoPrizeJudgment implements LottoPrizeJudgment {

    @Override
    public boolean judge(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        List<LottoNumber> winningNumbers = lottoWinningNumber.getLottoNumbers();

        return ListUtils.countCommonElements(lottoNumbers, winningNumbers) == 4;
    }
}
