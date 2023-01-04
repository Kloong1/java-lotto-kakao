package domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.LottoShop;

import java.util.Collections;
import java.util.List;
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
}
