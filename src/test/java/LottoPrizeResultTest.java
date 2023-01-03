import domain.lotto.LottoPrize;
import domain.lotto.LottoPrizeResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

public class LottoPrizeResultTest {

    HashMap<LottoPrize, Integer> prizeCounts;

    @BeforeEach
    void setUp() {
        prizeCounts = new HashMap<>();
        prizeCounts.put(LottoPrize.FIRST_PRIZE, 0);
        prizeCounts.put(LottoPrize.SECOND_PRIZE, 0);
        prizeCounts.put(LottoPrize.THIRD_PRIZE, 0);
        prizeCounts.put(LottoPrize.FOURTH_PRIZE, 0);
        prizeCounts.put(LottoPrize.FIFTH_PRIZE, 0);
        prizeCounts.put(LottoPrize.NONE_PRIZE, 0);
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
