package service;

import service.LottoPrizeCounter;
import domain.lotto.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.LottoPrizeResult;

import java.util.Arrays;
import java.util.HashMap;
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

    @DisplayName("로또 당첨 결과를 반환한다.")
    @Test
    void countPrize() {
        List<LottoTicket> lottoTickets = List.of(
                new LottoTicket(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                ))
        );

        HashMap<LottoPrize, Integer> expectedMap = new HashMap<>();
        expectedMap.put(LottoPrize.FIRST_PRIZE, 1);
        expectedMap.put(LottoPrize.SECOND_PRIZE, 0);
        expectedMap.put(LottoPrize.THIRD_PRIZE, 0);
        expectedMap.put(LottoPrize.FOURTH_PRIZE, 0);
        expectedMap.put(LottoPrize.FIFTH_PRIZE, 0);
        expectedMap.put(LottoPrize.NONE_PRIZE, 0);

        LottoPrizeResult expected = new LottoPrizeResult(expectedMap);

        LottoPrizeCounter lottoPrizeCounter = new LottoPrizeCounter(lottoWinningNumber);

        LottoPrizeResult result = lottoPrizeCounter.countPrize(lottoTickets);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
