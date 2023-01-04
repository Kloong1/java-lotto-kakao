package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersRandomGeneratorTest {

    @DisplayName(LottoNumber.MINIMUM_NUMBER + "~" + LottoNumber.MAXIMUM_NUMBER +
            "범위의 LottoNumbers를 생성하는 LottoNumbersRandomGenerator 객체를 만든다")
    @Test
    void create() {
        assertThatNoException()
                .isThrownBy(() ->
                        new LottoNumbersRandomGenerator(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER));
    }

    @DisplayName("로또 번호 생성 범위의 최솟값이 " + LottoNumber.MINIMUM_NUMBER + " 이상이어야 한다")
    @Test
    void validateLowerBound() {
        int lowerBound = LottoNumber.MINIMUM_NUMBER - 1;
        int upperBound = LottoNumber.MAXIMUM_NUMBER;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbersRandomGenerator(lowerBound, upperBound));
    }

    @DisplayName("로또 번호 생성 범위의 최댓값이 " + LottoNumber.MAXIMUM_NUMBER + " 이하이어야 한다")
    @Test
    void validateUpperBound() {
        int lowerBound = LottoNumber.MINIMUM_NUMBER;
        int upperBound = LottoNumber.MAXIMUM_NUMBER + 1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbersRandomGenerator(lowerBound, upperBound));
    }

    @DisplayName("로또 번호 생성 범위의 크기가 " + LottoNumbers.LOTTO_NUMBERS_SIZE + "이상이 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1, LottoNumbers.LOTTO_NUMBERS_SIZE - 1, 0, -1})
    void create_throw(int upperBound) {
        int lowerBound = LottoNumber.MINIMUM_NUMBER;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbersRandomGenerator(lowerBound, upperBound));
    }
}
