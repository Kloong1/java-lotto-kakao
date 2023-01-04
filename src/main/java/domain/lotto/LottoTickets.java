package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoNumbers> tickets;

    public LottoTickets(List<LottoNumbers> tickets) {
        validateTickets(tickets);
        this.tickets = new ArrayList<>(tickets);
    }

    private void validateTickets(List<LottoNumbers> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            throw new IllegalArgumentException("로또 복권은 한 장 이상이어야 합니다.");
        }
    }
}
