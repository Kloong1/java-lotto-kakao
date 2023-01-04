package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
    void generateLottoTicket() {
        List<LottoNumber> lottoNumbersFive = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );

        List<LottoNumber> lottoNumberSeven = new ArrayList<>(lottoNumbersFive);
        lottoNumberSeven.add(new LottoNumber(6));
        lottoNumberSeven.add(new LottoNumber(7));

        List<LottoNumber> lottoNumberOne = List.of(new LottoNumber(1));

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumbersFive));
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumberSeven));
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumberOne));
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(Collections.emptyList()));
    }

    @Test
    @DisplayName("생성된 로또 번호 중 중복이 있으면 예외가 발생한다")
    void generateLottoTicket_throw() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(1), //duplicate
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(lottoNumbers));
    }
}
