package lotto.domain.num;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumResultsTest {
    private LottoNumResults lottoNumResults;
    private WinLottoNums winLottoNums;
    private BonusLottoNum bonusLottoNum;

    @BeforeEach
    void setUp() {
        winLottoNums = new WinLottoNums("1,2,3,4,5,6");
        bonusLottoNum = new BonusLottoNum("7");
        lottoNumResults = new LottoNumResults("1,2,3,4,5,6", "7");
    }

    // TODO: 11/5/23 삭제 요망
//    @DisplayName("당첨 번호 추첨 번호들과, 보너스 번호들을 같은지 확인한다.")
//    @ParameterizedTest
//    @CsvSource({"1,0", "2,1", "3,2", "4,3", "5,4", "6,5", "7,6"})
//    void isSame(Integer targetNum, Integer indexOfSpecial) {
//        // when
//        Boolean result = lottoNumResults.isSame(targetNum);
//
//        // than
//        assertThat(result).isTrue();
//    }

    @DisplayName("당첨 번호 추첨 번호가 같은지 확인한다.")
    @ParameterizedTest
    @CsvSource({"1,0", "2,1", "3,2", "4,3", "5,4", "6,5"})
    void isSameWinNums(Integer targetNum, Integer indexOfSpecial) {
        // when
        Boolean result = lottoNumResults.isSameWinNums(targetNum);

        // than
        assertThat(result).isTrue();
    }

    @DisplayName("당첨 번호 추첨 번호가 같은지 확인한다.")
    @Test
    void isSameBonusNum() {
        Integer targetNum = 7;
        Integer indexOfSpecial = 6;

        // when
        Boolean result = lottoNumResults.isSameBonusNum(targetNum, indexOfSpecial);

        // than
        assertThat(result).isTrue();
    }

}