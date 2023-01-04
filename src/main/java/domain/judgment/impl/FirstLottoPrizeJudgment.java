package domain.judgment.impl;

import domain.judgment.LottoPrizeJudgment;
import domain.lotto.LottoNumber;
import domain.lotto.LottoNumbers;
import domain.lotto.LottoWinningNumber;
import util.SetUtils;

import java.util.HashSet;
import java.util.Set;

public class FirstLottoPrizeJudgment implements LottoPrizeJudgment {

    @Override
    public boolean judge(LottoNumbers lottoNumbers, LottoWinningNumber lottoWinningNumber) {
        Set<LottoNumber> numbers = lottoNumbers.getLottoNumbers();
        Set<LottoNumber> winningNumbers = new HashSet<>(lottoWinningNumber.getLottoNumbers());
        Set<LottoNumber> intersection = SetUtils.getIntersectionFrom(numbers, winningNumbers);

        return intersection.size() == 6;
    }

}
