package domain.lotto;

public interface LottoNumbersGenerator {
    LottoNumbers generate(int lowerBound, int upperBound);
}
