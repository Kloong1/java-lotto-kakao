package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LottoTicketTest {

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

        Set<LottoNumber> lottoNumberSeven = new HashSet<>(lottoNumbersFive);
        lottoNumberSeven.add(new LottoNumber(6));
        lottoNumberSeven.add(new LottoNumber(7));

        Set<LottoNumber> lottoNumberOne = Set.of(new LottoNumber(1));

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumbersFive));
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumberSeven));
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumberOne));
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(Collections.emptySet()));
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

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumbers));
    }
}
