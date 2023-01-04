package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호는 1부터 45 사이이다.")
    void validateRange() {
        assertThatNoException().isThrownBy(() -> new LottoNumber(2));
    }

    @DisplayName("범위 밖의 로또 번호를 생성하려고 하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -50, 46})
    void validateRange_throw(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }
}
