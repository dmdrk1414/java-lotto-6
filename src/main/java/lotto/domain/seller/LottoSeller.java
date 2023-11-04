package lotto.domain.seller;

import lotto.config.Config;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEnvelop;

/**
 * 로또 판매자 클래스
 */
public class LottoSeller {
    private static final Integer PRICE_LOTTO = 1000;
    private LottoEnvelop lottoEnvelop;

    /**
     * 사용자에게 로또 봉투판다.
     *
     * @return
     */
    public LottoEnvelop sell() {
        return lottoEnvelop;
    }

    /**
     * 돈을 받고 로또 봉투를 만든다.
     *
     * @param money 사용자가 주는 돈.
     */
    public void makeLottoEnvelope(Integer money) {
        Integer numberLotto = (money / PRICE_LOTTO);
        Lotto lotto = null;

        for (int index = 0; index < numberLotto; index++) {
            lotto = Config.lotto();
            lottoEnvelop.add(lotto);
        }
    }
}
