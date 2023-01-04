package service;

import domain.lotto.Cost;
import domain.lotto.LottoTicket;
import domain.lotto.LottoTicketGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoShop {

    public static final int LOTTO_PRICE = 1000;

    private final LottoTicketGenerator lottoTicketGenerator;

    public LottoShop(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public List<LottoTicket> buyLottoTickets(Cost cost) {
        validateCost(cost);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < cost.countAvailablePurchases(LOTTO_PRICE); i++) {
            lottoTickets.add(lottoTicketGenerator.generate());
        }
        return lottoTickets;
    }

    private void validateCost(Cost cost) {
        if (cost.countAvailablePurchases(LOTTO_PRICE) <= 0) {
            throw new IllegalArgumentException("잔액이 부족합니다");
        }
    }
}
