package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoNumbers> tickets;

    public LottoTickets(List<LottoNumbers> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }
}
