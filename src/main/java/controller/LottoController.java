package controller;

import service.LottoPrizeCounter;
import domain.lotto.*;
import domain.lotto.LottoPrizeResult;
import service.LottoShop;
import view.LottoInputView;
import view.LottoOutputView;

import java.util.List;

public class LottoController {

    private final LottoInputView lottoInputView = new LottoInputView();
    private final LottoOutputView lottoOutputView = new LottoOutputView();
    private final LottoShop lottoShop = new LottoShop(new LottoTicketRandomGenerator());

    public void startLotto() {
        Cost cost = lottoInputView.readCost();
        List<LottoTicket> lottoTickets = lottoShop.buyLottoTickets(cost);
        lottoOutputView.printLottoTickets(lottoTickets);
        LottoWinningNumber lottoWinningNumber = lottoInputView.readWinningNumber();

        LottoPrizeCounter lottoPrizeCounter = new LottoPrizeCounter(lottoWinningNumber);
        LottoPrizeResult lottoPrizeResult = lottoPrizeCounter.countPrize(lottoTickets);
        LottoEarningRate lottoEarningRate = lottoPrizeResult.calculateEarningRate(lottoTickets.size());
        lottoOutputView.printLottoResult(lottoPrizeResult.getPrizeCounts(), lottoEarningRate);
    }
}
