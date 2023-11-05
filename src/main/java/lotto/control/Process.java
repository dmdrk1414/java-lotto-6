package lotto.control;

import lotto.config.Config;
import lotto.domain.host.LottoHost;
import lotto.domain.lotto.LottoEnvelop;
import lotto.domain.num.LottoTargetNumResults;
import lotto.domain.seller.LottoSeller;
import lotto.domain.user.User;

public class Process {
    private User user;
    private LottoSeller lottoSeller;
    private LottoHost lottoHost;
    private LottoTargetNumResults lottoTargetNumResults;

    public Process() {
        this.user = Config.user();
        this.lottoSeller = Config.lottoSeller();
        this.lottoHost = Config.lottoHost();
        lottoTargetNumResults = null;
    }

    /**
     * 로또를 산다.
     */
    public void buyLotto() {
        LottoEnvelop lottoEnvelop = null;

        // 유저가 로또를 산다.
        Integer moneyOfUser = user.payMoney();

        // 로또 판매자가 로또를 판다.
        lottoEnvelop = lottoSeller.sell(moneyOfUser);

        // 유저가 봉투를 받는다.
        user.takeLottoEnvelop(lottoEnvelop);
    }

    /**
     * 로또를 보여준다.
     */
    public StringBuilder showLotto() {
        return user.showLottoEnvelop();
    }

    /**
     * 게임 진행자가 당첨 번호를 뽑는다.
     */
    public String pickWinNumber() {
        // 로또진행자가 당첨 번호를 뽑는다.
        return lottoHost.pickWinNumbers();
    }

    // TODO: 11/5/23  로또 진행자가 보너스 번호를 입력한다.
    public String pickBonusNumber() {
        return lottoHost.pickBonusNumber();
    }

    /**
     * 당첨의 결과를 보여준다.
     *
     * @return
     */
    public StringBuilder showStatisticResult() {
        lottoTargetNumResults = lottoHost.giveLottoTargetNumResults();
        return user.showStatisticLottoResult(lottoTargetNumResults);
    }

    public StringBuilder showRateResult() {
        return user.calculateTotalRate();
    }
}
