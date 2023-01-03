import domain.lotto.LottoNumber;
import domain.lotto.LottoWinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoPrizeCounterTest {

    LottoWinningNumber lottoWinningNumber;

    @BeforeEach
    void setUp() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        LottoNumber bonusNumber = new LottoNumber(10);

        lottoWinningNumber = new LottoWinningNumber(lottoNumbers, bonusNumber);
    }

    @DisplayName("로또 당첨 번호로 로또 당첨 카운터 객체를 생성한다")
    @Test
    void create() {
        Assertions.assertThatNoException().isThrownBy(() -> new LottoPrizeCounter(lottoWinningNumber));
    }
}
