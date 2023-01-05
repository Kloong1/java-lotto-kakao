package controller;

import domain.lotto.*;
import domain.lotto.LottoPrizeResult;
import domain.lotto.LottoShop;
import view.LottoInputView;
import view.LottoOutputView;

public class LottoController {

    private final LottoInputView lottoInputView = new LottoInputView();
    private final LottoOutputView lottoOutputView = new LottoOutputView();
    private final LottoShop lottoShop = new LottoShop(
            new LottoNumbersRandomGenerator(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER));

    public void startLotto() {
        Cost cost = lottoInputView.readCost();
        LottoTickets lottoTickets = lottoShop.buyLottoTickets(cost);
        lottoOutputView.printLottoTicketPurchaseCount(lottoTickets);
        lottoOutputView.printLottoTickets(lottoTickets);
        LottoWinningNumbers lottoWinningNumbers = lottoInputView.readLottoWinningNumbers();

        LottoPrizeResult lottoPrizeResult = lottoTickets.matchTickets(lottoWinningNumbers);
        LottoEarningRate lottoEarningRate = new LottoEarningRate(lottoPrizeResult, lottoTickets);
        lottoOutputView.printLottoPrizeResult(lottoPrizeResult);
        lottoOutputView.printEarningRate(lottoEarningRate);
    }
}
