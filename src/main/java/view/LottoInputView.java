package view;

import domain.lotto.Cost;
import domain.lotto.LottoNumber;
import domain.lotto.LottoNumbers;
import domain.lotto.LottoWinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoInputView {

    private static final Scanner sc = new Scanner(System.in);

    public Cost readCost() {
        System.out.println("구매금액을 입력해 주세요.");
        int inputCost = Integer.parseInt(sc.nextLine());

        return new Cost(inputCost);
    }

    public LottoWinningNumber readWinningNumber() {
        LottoNumbers lottoNumbers = readLottoNumbers();
        LottoNumber bonusNumber = readBonusNumber();
        return new LottoWinningNumber(lottoNumbers, bonusNumber);
    }

    private LottoNumbers readLottoNumbers() {
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
        String input = sc.nextLine();
        String[] inputStrings = input.split(",");
        Set<LottoNumber> lottoNumbers = Arrays.stream(inputStrings)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
        return new LottoNumbers(lottoNumbers);
    }

    private LottoNumber readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBallNumber = Integer.parseInt(sc.nextLine());

        return new LottoNumber(bonusBallNumber);
    }
}
