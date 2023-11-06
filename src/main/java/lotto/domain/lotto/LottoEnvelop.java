package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoEnvelop {
    private List<Lotto> lottoEnvelop;

    public LottoEnvelop() {
        lottoEnvelop = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottoEnvelop.add(lotto);
    }

    public Integer size() {
        return lottoEnvelop.size();
    }

    public StringBuilder giveInformation() {
        int sizeLottoEnvelop = lottoEnvelop.size();

        StringBuilder information = getInformationEnvelop(sizeLottoEnvelop);

        return information;
    }

    private StringBuilder getInformationEnvelop(int sizeLottoEnvelop) {
        Lotto lotto;
        StringBuilder lottoInformation;
        StringBuilder information = new StringBuilder();

        for (int i = 0; i < sizeLottoEnvelop; i++) {
            lotto = getLotto(i);
            lottoInformation = getLottoInformation(lotto);
            appendLottoInformation(lottoInformation, information);
        }
        return information;
    }

    private StringBuilder getLottoInformation(Lotto lotto) {
        return lotto.giveInformation();
    }

    private void appendLottoInformation(StringBuilder lottoInformation, StringBuilder information) {
        information.append(lottoInformation + "\n");
    }

    private Lotto getLotto(int i) {
        return lottoEnvelop.get(i);
    }

    public Lotto takeLotto(Integer index) {
        return this.lottoEnvelop.get(index);
    }
}
