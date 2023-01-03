import domain.lotto.LottoNumber;
import domain.lotto.LottoPrize;
import domain.lotto.LottoTicket;
import domain.lotto.LottoWinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoNumberMatcherTest {

    LottoWinningNumber lottoWinningNumber;
    LottoTicket lottoTicket;
    LottoNumberMatcher lottoNumberMatcher;

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

        lottoNumberMatcher = new LottoNumberMatcher(lottoWinningNumber);
    }

    @DisplayName("모든 숫자가 일치하면 1등이다")
    @Test
    void match_first() {
        lottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));


        Assertions.assertThat(lottoNumberMatcher.match(lottoTicket))
                .isEqualTo(LottoPrize.FIRST_PRIZE);
    }

    @DisplayName("5개 맞고 보너스 숫자 맞으면 2등이다.")
    @Test
    void secondPrize() {
        lottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(10)
        ));

        Assertions.assertThat(lottoNumberMatcher.match(lottoTicket))
                .isEqualTo(LottoPrize.SECOND_PRIZE);
    }

    @DisplayName("5개 맞으면 3등이다.")
    @Test
    void thirdPrize() {
        lottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(41)
        ));

        Assertions.assertThat(lottoNumberMatcher.match(lottoTicket))
                .isEqualTo(LottoPrize.THIRD_PRIZE);
    }

    @DisplayName("4개 맞으면 4등이다.")
    @Test
    void fourthPrize() {
        lottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(41),
                new LottoNumber(42)
        ));

        Assertions.assertThat(lottoNumberMatcher.match(lottoTicket))
                .isEqualTo(LottoPrize.FOURTH_PRIZE);
    }

    @DisplayName("3개 맞으면 5등이다.")
    @Test
    void fifthPrize() {
        lottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43)
        ));

        Assertions.assertThat(lottoNumberMatcher.match(lottoTicket))
                .isEqualTo(LottoPrize.FIFTH_PRIZE);
    }

    @DisplayName("2개 이하로 맞으면 꽝이다.")
    @Test
    void nonePrize() {
        lottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(40),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43)
        ));

        Assertions.assertThat(lottoNumberMatcher.match(lottoTicket))
                .isEqualTo(LottoPrize.NONE_PRIZE);
    }

}
