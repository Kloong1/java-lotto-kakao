package view;

import domain.lotto.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoOutputView {
    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getTicketCount() + "개를 구매했습니다.");
        lottoTickets.getTickets().stream()
                .map(LottoNumbers::getNumbers)
                .forEach(this::printLottoNumbers);
    }

    public void printLottoResult(Map<LottoPrize, Integer> prizeCounts, LottoEarningRate lottoEarningRate) {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("----------");
        printPrizeCount(prizeCounts);
        printEarningRate(lottoEarningRate);
    }

    private void printPrizeCount(Map<LottoPrize, Integer> prizeCounts) {
        System.out.printf("3개 일치 (%d원)- %d개%n",
                LottoPrize.FIFTH_PRIZE.getPrizeMoney(), prizeCounts.get(LottoPrize.FIFTH_PRIZE));
        System.out.printf("4개 일치 (%d원)- %d개%n",
                LottoPrize.FOURTH_PRIZE.getPrizeMoney(), prizeCounts.get(LottoPrize.FOURTH_PRIZE));
        System.out.printf("5개 일치 (%d원)- %d개%n",
                LottoPrize.THIRD_PRIZE.getPrizeMoney(), prizeCounts.get(LottoPrize.THIRD_PRIZE));
        System.out.printf("5개 일치, 보너스 볼 일치 (%d원)- %d개%n",
                LottoPrize.SECOND_PRIZE.getPrizeMoney(), prizeCounts.get(LottoPrize.SECOND_PRIZE));
        System.out.printf("6개 일치 (%d원)- %d개%n",
                LottoPrize.FIRST_PRIZE.getPrizeMoney(), prizeCounts.get(LottoPrize.FIRST_PRIZE));
    }

    private void printLottoNumbers(Set<LottoNumber> lottoNumbers) {
        String numbers = lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("[" + numbers + "]");
    }

    private void printEarningRate(LottoEarningRate lottoEarningRate) {
        System.out.printf("총 수익률은 %.2f입니다.%n", lottoEarningRate.getEarningRate());
    }
}
