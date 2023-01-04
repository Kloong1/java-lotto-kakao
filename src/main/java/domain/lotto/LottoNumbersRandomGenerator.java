package domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersRandomGenerator implements LottoNumbersGenerator {

    @Override
    public LottoNumbers generate(int lowerBound, int upperBound) {
        List<LottoNumber> lottoNumberCandidates = IntStream.range(lowerBound, upperBound)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumberCandidates);
        Set<LottoNumber> lottoNumbers = lottoNumberCandidates.stream()
                .limit(6)
                .collect(Collectors.toSet());
        return new LottoNumbers(lottoNumbers);
    }
}
