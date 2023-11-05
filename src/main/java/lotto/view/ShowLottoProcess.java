package lotto.view;

import lotto.config.Config;
import lotto.control.Process;

public class ShowLottoProcess {
    private Process process;

    public ShowLottoProcess() {
        this.process = Config.process();
    }

    public void printBuyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        process.buyLotto();
        System.out.println();
    }

    public void printNumberBuyLotto() {
        System.out.println(process.tellNumberLotto());
    }

    public void printInformationUserLotto() {
        System.out.println(process.showLottosInformation());
        System.out.println();
    }

    public void printPickWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        process.pickWinNumber();
        System.out.println();
    }

    public void printPickBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
        process.pickBonusNumber();
        System.out.println();
    }

    public void printStatisticResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(process.showStatisticResult());
    }

    public void printRateResult() {
        System.out.println(process.showRateResult());
    }
}
