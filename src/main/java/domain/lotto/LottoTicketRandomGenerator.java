package domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketRandomGenerator implements LottoTicketGenerator {

    @Override
    public LottoTicket generate() {
        List<LottoNumber> lottoNumberCandidates = IntStream.range(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumberCandidates);
        return new LottoTicket(lottoNumberCandidates.subList(0, LottoTicket.LOTTO_NUMBERS_SIZE));
    }
}
