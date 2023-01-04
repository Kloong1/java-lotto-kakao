package domain.lotto;

import java.util.*;

public class LottoNumbers {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public LottoNumbers(Set<LottoNumber> numbers) {
        validateSize(numbers);
        this.numbers = new HashSet<>(numbers);
    }

    public Set<LottoNumber> getNumbers() {
        return new HashSet<>(numbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int countCommonLottoNumbers(LottoNumbers other) {
        HashSet<LottoNumber> intersection = new HashSet<>(numbers);
        intersection.retainAll(other.getNumbers());
        return intersection.size();
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }
}
