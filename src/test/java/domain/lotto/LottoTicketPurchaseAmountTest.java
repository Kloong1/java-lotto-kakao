package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;

public class LottoTicketPurchaseAmountTest {

    @DisplayName("Cost와 로또 구매 개수를 넘겨 받아서 로또 구매 개수 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    void create(int purchaseAmount) {
        Cost cost = new Cost(10_000);
        assertThatNoException()
                .isThrownBy(() -> new LottoTicketPurchaseAmount(purchaseAmount, cost));
    }
}
