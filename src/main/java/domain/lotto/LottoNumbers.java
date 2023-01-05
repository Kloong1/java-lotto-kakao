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
        Set<LottoNumber> intersection = new HashSet<>(numbers);
        intersection.retainAll(other.getNumbers());
        return intersection.size();
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
