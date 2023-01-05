package domain.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    public static final int LOTTO_PRICE = 1000;

    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoShop(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public LottoTickets buyLottoTickets(Cost cost) {
        validateCost(cost);
        List<LottoNumbers> tickets = IntStream.range(0, cost.countAvailablePurchases(LOTTO_PRICE))
                .mapToObj(idx -> lottoNumbersGenerator.generate())
                .collect(Collectors.toList());
        return new LottoTickets(tickets);
    }

    private void validateCost(Cost cost) {
        if (cost.countAvailablePurchases(LOTTO_PRICE) <= 0) {
            throw new IllegalArgumentException("잔액이 부족합니다");
        }
    }
}
