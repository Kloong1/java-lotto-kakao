package service;

import domain.lotto.Cost;
import domain.lotto.LottoNumber;
import domain.lotto.LottoNumbers;
import domain.lotto.LottoTicketGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    public static final int LOTTO_PRICE = 1000;

    private final LottoTicketGenerator lottoTicketGenerator;

    public LottoShop(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public List<LottoNumbers> buyLottoTickets(Cost cost) {
        validateCost(cost);
        return IntStream.range(0, cost.countAvailablePurchases(LOTTO_PRICE))
                .mapToObj(idx -> lottoTicketGenerator.generate(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER))
                .collect(Collectors.toList());
    }

    private void validateCost(Cost cost) {
        if (cost.countAvailablePurchases(LOTTO_PRICE) <= 0) {
            throw new IllegalArgumentException("잔액이 부족합니다");
        }
    }
}
