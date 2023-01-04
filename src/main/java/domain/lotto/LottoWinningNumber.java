package domain.lotto;

import util.ListUtils;

import java.util.Collections;
import java.util.List;

public class LottoWinningNumber {

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumber(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        validateDuplicates(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public void validateDuplicates(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("중복된 로또 번호가 있습니다.");
        }
    }
}
