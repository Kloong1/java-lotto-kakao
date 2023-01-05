package domain.lotto;

public class LottoTicketPurchaseAmount {
    public static final int MINIMUM_PURCHASE_AMOUNT = 0;
    private final int purchaseAmount;

    public LottoTicketPurchaseAmount(int purchaseAmount, Cost cost) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount < MINIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("로또 구매 개수는 0 이상이어야 합니다.");
        }
    }
}
