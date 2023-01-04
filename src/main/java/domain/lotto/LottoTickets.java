package domain.lotto;

import service.LottoShop;

import java.util.*;

public class LottoTickets {
    private final List<LottoNumbers> tickets;

    public LottoTickets(List<LottoNumbers> tickets) {
        validateTickets(tickets);
        this.tickets = new ArrayList<>(tickets);
    }

    public Cost calculatePurcaseCost() {
        return new Cost(tickets.size() * LottoShop.LOTTO_PRICE);
    }

    public LottoPrizeResult matchTickets(LottoWinningNumber lottoWinningNumber) {
        Map<LottoPrize, Integer> prizeCounts = new EnumMap<>(LottoPrize.class);
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> prizeCounts.put(prize, 0));

        tickets.stream()
                .map(lottoNumbers -> LottoPrize.matchLottoNumbers(lottoNumbers, lottoWinningNumber))
                .forEach(lottoPrize -> prizeCounts.computeIfPresent(lottoPrize, (prize, count) -> count + 1));

        return new LottoPrizeResult(prizeCounts);
    }

    public int getTicketCount() {
        return tickets.size();
    }

    private void validateTickets(List<LottoNumbers> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            throw new IllegalArgumentException("로또 복권은 한 장 이상이어야 합니다.");
        }
    }
}
