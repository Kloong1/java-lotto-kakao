package domain.judgment.impl;

import domain.judgment.LottoPrizeJudgment;
import domain.lotto.LottoNumber;
import domain.lotto.LottoTicket;
import domain.lotto.LottoWinningNumber;
import util.ListUtils;
import util.SetUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoneLottoPrizeJudgment implements LottoPrizeJudgment {

    @Override
    public boolean judge(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        Set<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        Set<LottoNumber> winningNumbers = new HashSet<>(lottoWinningNumber.getLottoNumbers());
        Set<LottoNumber> intersection = SetUtils.getIntersectionFrom(lottoNumbers, winningNumbers);

        return intersection.size() <= 2;
    }
}
