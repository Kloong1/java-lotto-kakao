package domain.lotto;

import java.util.*;

public class LottoNumbers {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return new HashSet<>(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int countCommonLottoNumbers(LottoNumbers other) {
        HashSet<LottoNumber> intersection = new HashSet<>(lottoNumbers);
        intersection.retainAll(other.getLottoNumbers());
        return intersection.size();
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }
}
