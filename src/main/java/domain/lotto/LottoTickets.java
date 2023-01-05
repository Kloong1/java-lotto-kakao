package domain.lotto;

import java.util.*;

public class LottoTickets {
    private final List<LottoNumbers> autoTickets;
    private List<LottoNumbers> manualTickets;

    public LottoTickets(List<LottoNumbers> autoTickets) {
        validateTickets(autoTickets);
        this.autoTickets = autoTickets;
    }

    public LottoTickets(List<LottoNumbers> autoTickets, List<LottoNumbers> manualTickets) {
        validateTickets(autoTickets);
        validateTickets(manualTickets);
        this.autoTickets = new ArrayList<>(autoTickets);
        this.manualTickets = new ArrayList<>(manualTickets);
    }

    public List<LottoNumbers> getTickets() {
        return new ArrayList<>(autoTickets);
    }

    public Cost calculatePurcaseCost() {
        return new Cost(autoTickets.size() * LottoShop.LOTTO_PRICE);
    }

    public LottoPrizeResult matchTickets(LottoWinningNumber lottoWinningNumber) {
        Map<LottoPrize, Integer> prizeCounts = new EnumMap<>(LottoPrize.class);
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> prizeCounts.put(prize, 0));

        autoTickets.stream()
                .map(lottoNumbers -> LottoPrize.matchLottoNumbers(lottoNumbers, lottoWinningNumber))
                .forEach(lottoPrize -> prizeCounts.computeIfPresent(lottoPrize, (prize, count) -> count + 1));

        return new LottoPrizeResult(prizeCounts);
    }

    public int getTicketCount() {
        return autoTickets.size();
    }

    private void validateTickets(List<LottoNumbers> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            throw new IllegalArgumentException("로또 복권은 한 장 이상이어야 합니다.");
        }
    }
}
