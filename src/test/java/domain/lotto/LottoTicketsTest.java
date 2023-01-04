package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketsTest {

    @DisplayName("LottoNumbers의 List를 넘겨받아서 LottoTickets를 생성한다.")
    @Test
    void create() {
        LottoNumbersRandomGenerator lottoNumbersRandomGenerator =
                new LottoNumbersRandomGenerator(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER);

        List<LottoNumbers> lottoNumbers = IntStream.range(0, 10)
                .mapToObj(i -> lottoNumbersRandomGenerator.generate())
                .collect(Collectors.toList());

        Assertions.assertThatNoException()
                .isThrownBy(() -> new LottoTickets(lottoNumbers));
    }
}
