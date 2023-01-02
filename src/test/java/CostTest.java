import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CostTest {
    @Test
    @DisplayName("구매 금액은 1원 이상이다")
    void validateRange() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Cost(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -100})
    @DisplayName("1원 미만의 금액이면 예외가 발생한다")
    void validateRange_throw(int value) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cost(value));
    }
}
