import java.util.List;

public class FourthLottoPrizeJudgment implements LottoPrizeJudgment {

    @Override
    public boolean judge(LottoTicket lottoTicket, LottoWinningNumber lottoWinningNumber) {
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        List<LottoNumber> winningNumbers = lottoWinningNumber.getLottoNumbers();

        return ListUtils.countCommonElements(lottoNumbers, winningNumbers) == 3;
    }
}
