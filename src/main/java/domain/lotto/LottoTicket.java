package domain.lotto;

import java.util.*;

public class LottoTicket {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return new HashSet<>(lottoNumbers);
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }
}
