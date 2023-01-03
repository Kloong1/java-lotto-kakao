import java.util.List;

public class FirstLottoPrizeJudgment implements LottoPrizeJudgment {

    @Override
    public boolean judge(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        List<LottoNumber> winningNumbers = lottoWinningNumber.getLottoNumbers();

        return lottoNumbers.containsAll(winningNumbers);
    }

}
