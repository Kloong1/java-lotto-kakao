package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class LottoWinningNumberTest {

    @DisplayName("당첨 번호 6개와 보너스 번호 1개를 주입받아서 생성한다")
    @Test
    void create() {
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)

        ));
        LottoNumber bonusNumber = new LottoNumber(10);

        Assertions.assertThatNoException()
                .isThrownBy(() -> new LottoWinningNumber(lottoNumbers, bonusNumber));
    }
}
