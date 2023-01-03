package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoEarningRateTest {

    @DisplayName("수익률은 양수이고 double이다.")
    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.123, 0.9, 123412.0, 0.0})
    void create(double earningRate) {
        Assertions.assertThatNoException().isThrownBy(() -> new LottoEarningRate(earningRate));
    }

    @DisplayName("음수 수익률이 들어오면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(doubles = {-0.1, -3.8})
    void create_throw(double earningRate) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new LottoEarningRate(earningRate));
    }
}
