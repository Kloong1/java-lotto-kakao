package domain.lotto;

public interface LottoTicketGenerator {
    LottoNumbers generate(int lowerBound, int upperBound);
}
