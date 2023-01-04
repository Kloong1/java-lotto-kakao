package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoEarningRateTest {

    @DisplayName("수익률은 양수이고 double이다.")
    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.123, 0.9, 123412.0, 0.0})
    void create(double earningRate) {
        assertThatNoException().isThrownBy(() -> new LottoEarningRate(earningRate));
    }

    @DisplayName("음수 수익률이 들어오면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(doubles = {-0.1, -3.8})
    void create_throw(double earningRate) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoEarningRate(earningRate));
    }

    @DisplayName("LottoPrizeResult와 Cost를 넘겨 받아 수익률을 계산한다")
    @Test
    void create_fromPrizeAndCost() {
        Map<LottoPrize, Integer> prizeCounts = new EnumMap<>(LottoPrize.class);
        Arrays.stream(LottoPrize.values())
                .forEach(lottoPrize -> prizeCounts.put(lottoPrize, 0));
        prizeCounts.put(LottoPrize.FIRST_PRIZE, 1);

        LottoPrizeResult lottoPrizeResult = new LottoPrizeResult(prizeCounts);
        Cost cost = new Cost(10_000);

        LottoEarningRate lottoEarningRate = new LottoEarningRate(lottoPrizeResult, cost);

        assertThat(lottoEarningRate.getEarningRate())
                .isEqualTo((double) LottoPrize.FIRST_PRIZE.getPrizeMoney() / cost.getCost());
    }
}
