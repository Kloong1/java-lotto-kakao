package domain.lotto;

import service.LottoShop;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoNumbers> tickets;

    public LottoTickets(List<LottoNumbers> tickets) {
        validateTickets(tickets);
        this.tickets = new ArrayList<>(tickets);
    }

    public Cost calculatePurcaseCost() {
        return new Cost(tickets.size() * LottoShop.LOTTO_PRICE);
    }

    private void validateTickets(List<LottoNumbers> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            throw new IllegalArgumentException("로또 복권은 한 장 이상이어야 합니다.");
        }
    }
}
