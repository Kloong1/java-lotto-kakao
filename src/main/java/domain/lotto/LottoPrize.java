package domain.lotto;

import domain.judgment.LottoPrizeJudgment;
import domain.judgment.impl.*;

public enum LottoPrize {

    FIRST_PRIZE(2_000_000_000, new FirstLottoPrizeJudgment()),
    SECOND_PRIZE(30_000_000, new SecondLottoPrizeJudgment()),
    THIRD_PRIZE(1_500_000, new ThirdLottoPrizeJudgment()),
    FOURTH_PRIZE(50_000, new FourthLottoPrizeJudgment()),
    FIFTH_PRIZE(5_000, new FifthLottoPrizeJudgment()),
    NONE_PRIZE(0, new NoneLottoPrizeJudgment());

    private final int prizeMoney;
    public final LottoPrizeJudgment prizeJudgment;

    LottoPrize(int prizeMoney, LottoPrizeJudgment prizeJudgment) {
        this.prizeMoney = prizeMoney;
        this.prizeJudgment = prizeJudgment;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
