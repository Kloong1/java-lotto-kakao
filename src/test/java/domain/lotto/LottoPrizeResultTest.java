package domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoPrizeResultTest {

    Map<LottoPrize, Integer> prizeCounts;

    @BeforeEach
    void setUp() {
        prizeCounts = new HashMap<>();
        Arrays.stream(LottoPrize.values())
                        .forEach(lottoPrize -> prizeCounts.put(lottoPrize, 0));
    }

    @DisplayName("Map<LottoPrize, Integer>를 주입받아 LottoResult를 생성한다")
    @Test
    void create() {
        assertThatNoException().isThrownBy(() -> new LottoPrizeResult(prizeCounts));
    }

    @DisplayName("잘못된 등수 카운트가 들어오면 예외가 발생한다")
    @Test
    void create_throw() {
        prizeCounts.remove(LottoPrize.FIRST_PRIZE);
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoPrizeResult(prizeCounts));
    }
}
