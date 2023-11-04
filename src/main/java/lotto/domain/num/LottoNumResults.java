package lotto.domain.num;

import lotto.utill.Utii;

/**
 * 당첨 번호와 보너스 번호들의 모임 클래스
 */
public class LottoNumResults {
    private static final Integer BONUS_INDEX_NUM = 6;
    private static final Integer START_PICK_NUM_INDEX = 0;
    private static final Integer END_PICK_NUM_INDEX = 5;
    private WinLottoNums winLottoNums;
    private BonusLottoNum bonusLottoNum;
    private Boolean isSame;

    public LottoNumResults(WinLottoNums winLottoNums, BonusLottoNum bonusLottoNum) {
        this.winLottoNums = winLottoNums;
        this.bonusLottoNum = bonusLottoNum;
        isSame = false;
    }

    public Boolean isSame(Integer targetNum, Integer indexOfSpecial) {
        isSame = isSameWinNums(targetNum, indexOfSpecial);
        isSame = isSameBonusNum(targetNum, indexOfSpecial);

        return null;
    }

    /**
     * 당첨 번호 추첨 번호가 같은지 확인한다.
     *
     * @param targetNum 확인하기 위한 번호
     * @return
     */
    public Boolean isSameWinNums(Integer targetNum, Integer indexOfSpecial) {
        if (isContainScope(indexOfSpecial)) {
            return winLottoNums.isSame(targetNum, indexOfSpecial);
        }

        return false;
    }

    /**
     * 보너스 번호가 같은지 확인
     *
     * @param targetNum
     * @return
     */
    public Boolean isSameBonusNum(Integer targetNum, Integer indexOfSpecial) {
        if (Utii.isSameInt(indexOfSpecial, BONUS_INDEX_NUM)) {
            return bonusLottoNum.isSame(targetNum);
        }

        return false;
    }

    private boolean isContainScope(Integer indexOfSpecial) {
        return indexOfSpecial >= START_PICK_NUM_INDEX
                && indexOfSpecial <= END_PICK_NUM_INDEX;
    }


}
