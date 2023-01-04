package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.LottoShop;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {
    LottoNumbersGenerator lottoNumbersGenerator;

    @BeforeEach
    void setUp() {
        lottoNumbersGenerator = new LottoNumbersRandomGenerator(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER);
    }

    @DisplayName("LottoNumbers의 List를 넘겨받아서 LottoTickets를 생성한다.")
    @Test
    void create() {
        List<LottoNumbers> lottoNumbers = IntStream.range(0, 10)
                .mapToObj(i -> lottoNumbersGenerator.generate())
                .collect(Collectors.toList());

        assertThatNoException()
                .isThrownBy(() -> new LottoTickets(lottoNumbers));
    }

    @DisplayName("비어있는 LottoNumbers의 List가 들어오면 예외가 발생한다.")
    @Test
    void create_throw() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTickets(Collections.emptyList()));
    }

    @DisplayName("로또 구매 금액을 계산한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 50, 100})
    void calculatePurchaseCost(int ticketCount) {
        List<LottoNumbers> tickets = IntStream.range(0, ticketCount)
                .mapToObj(i -> lottoNumbersGenerator.generate())
                .collect(Collectors.toList());

        LottoTickets lottoTickets = new LottoTickets(tickets);

        Cost cost = lottoTickets.calculatePurcaseCost();

        assertThat(cost).isEqualTo(new Cost(LottoShop.LOTTO_PRICE * ticketCount));
    }


    @DisplayName("당첨 번호와 비교해서 로또 당첨 결과를 반환한다. - 1등")
    @Test
    void matchTickets1() {
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        LottoTickets lottoTickets = new LottoTickets(List.of(lottoNumbers));

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoNumbers, new LottoNumber(45));

        Map<LottoPrize, Integer> expectedMap = new EnumMap<>(LottoPrize.class);
        Arrays.stream(LottoPrize.values())
                .forEach(lottoPrize -> expectedMap.put(lottoPrize, 0));
        expectedMap.put(LottoPrize.FIRST_PRIZE, 1);

        LottoPrizeResult expected = new LottoPrizeResult(expectedMap);

        LottoPrizeResult result = lottoTickets.matchTickets(lottoWinningNumber);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("당첨 번호와 비교해서 로또 당첨 결과를 반환한다. - 2등")
    @Test
    void countPrize2() {
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        LottoTickets lottoTickets = new LottoTickets(List.of(lottoNumbers));

        LottoNumbers winningNumbers = new LottoNumbers(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(45)
        ));

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumbers, new LottoNumber(6));

        Map<LottoPrize, Integer> expectedMap = new EnumMap<>(LottoPrize.class);
        Arrays.stream(LottoPrize.values())
                .forEach(lottoPrize -> expectedMap.put(lottoPrize, 0));
        expectedMap.put(LottoPrize.SECOND_PRIZE, 1);

        LottoPrizeResult expected = new LottoPrizeResult(expectedMap);

        LottoPrizeResult result = lottoTickets.matchTickets(lottoWinningNumber);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
