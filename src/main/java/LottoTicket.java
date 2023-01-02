import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicates(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicates(List<LottoNumber> lottoNumbers) {
        long distinctCount = lottoNumbers.stream()
                .distinct()
                .count();
        if (distinctCount < lottoNumbers.size()) {
            throw new IllegalStateException("중복된 로또 번호가 있습니다.");
        }
    }
}
