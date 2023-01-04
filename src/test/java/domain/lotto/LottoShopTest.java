package domain.lotto;

import domain.lotto.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoShopTest {

    @DisplayName("구매 금액에 맞는 로또 티켓 리스트를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {3_000, 1_001, 15_999})
    void buyLottoTickets(int money) {
        Cost cost = new Cost(money);
        LottoShop lottoShop = new LottoShop(
                new LottoNumbersRandomGenerator(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER));

        LottoTickets lottoTickets = lottoShop.buyLottoTickets(cost);
        assertThat(lottoTickets.getTicketCount())
                .isEqualTo(money / LottoShop.LOTTO_PRICE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, LottoShop.LOTTO_PRICE - 1})
    @DisplayName("로또를 한 장도 못사는 경우에는 예외가 발생한다.")
    void buyLottoTickets_throw(int money) {
        Cost cost = new Cost(money);
        LottoShop lottoShop = new LottoShop(
                new LottoNumbersRandomGenerator(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoShop.buyLottoTickets(cost));
    }
}
