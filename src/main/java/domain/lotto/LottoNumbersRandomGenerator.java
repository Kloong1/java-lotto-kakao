package domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersRandomGenerator implements LottoNumbersGenerator {

    private final int lowerBound;
    private final int upperBound;

    public LottoNumbersRandomGenerator(int lowerBound, int upperBound) {
        validateBound(lowerBound, upperBound);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public LottoNumbers generate() {
        List<LottoNumber> lottoNumberCandidates = generateLottoNumberCandidates();
        return new LottoNumbers(selectLottoNumbers(lottoNumberCandidates));
    }

    private void validateBound(int lowerBound, int upperBound) {
        if (lowerBound < LottoNumber.MINIMUM_NUMBER) {
            throw new IllegalArgumentException("숫자 생성 범위의 최솟값은 로또 번호의 최솟값 이상이어야 합니다.");
        }
        if (upperBound > LottoNumber.MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("숫자 생성 범위의 최댓값은 로또 번호의 최댓값 이하이어야 합니다.");
        }
        int sizeOfLottoNumberCandidates = upperBound - lowerBound + 1;
        if (sizeOfLottoNumberCandidates < LottoNumbers.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("숫자 생성 범위의 크기는 로또 번호 개수보다 커야 합니다");
        }
    }

    private List<LottoNumber> generateLottoNumberCandidates() {
        List<LottoNumber> lottoNumberCandidates = IntStream.rangeClosed(lowerBound, upperBound)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumberCandidates);
        return lottoNumberCandidates;
    }

    private Set<LottoNumber> selectLottoNumbers(List<LottoNumber> lottoNumberCandidates) {
        return lottoNumberCandidates.stream()
                .limit(LottoNumbers.LOTTO_NUMBERS_SIZE)
                .collect(Collectors.toSet());
    }
}
