package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
    void generateLottoTicket() {
        Set<LottoNumber> lottoNumbersFive = Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );

        Set<LottoNumber> lottoNumbersSeven = new HashSet<>(lottoNumbersFive);
        lottoNumbersSeven.add(new LottoNumber(6));
        lottoNumbersSeven.add(new LottoNumber(7));

        Set<LottoNumber> lottoNumbersOne = Set.of(new LottoNumber(1));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(lottoNumbersFive));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(lottoNumbersSeven));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(lottoNumbersOne));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(Collections.emptySet()));
    }

    @Test
    @DisplayName("생성된 로또 번호 중 중복이 있으면 예외가 발생한다")
    void generateLottoTicket_throw() {
        Set<LottoNumber> lottoNumbers = new HashSet<>(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        ));

        lottoNumbers.add(new LottoNumber(1)); //duplicate

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(lottoNumbers));
    }

    @DisplayName("로또 번호들 중 넘겨받은 로또 번호와 같은 번호가 있으면 true를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void contains_true(int number) {
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        boolean result = lottoNumbers.contains(new LottoNumber(number));
        assertThat(result).isTrue();
    }

    @DisplayName("로또 번호들 중 넘겨받은 로또 번호와 같은 번호가 없으면 false를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {10, 30, 45})
    void contains_false(int number) {
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        boolean result = lottoNumbers.contains(new LottoNumber(number));
        assertThat(result).isFalse();
    }
}
