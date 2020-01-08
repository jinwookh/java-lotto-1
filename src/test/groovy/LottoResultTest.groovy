import lotto.domain.lotto.Lotto
import lotto.domain.lotto.LottoResult
import lotto.domain.lotto.Lottos
import lotto.domain.lotto.WinningLotto
import lotto.domain.money.Money
import spock.lang.Specification

class LottoResultTest extends Specification {

    def "수익률"(List<Integer> numbers, List<Integer> winningNumbers, int bonusNumber, double result) {
        given:
        List<Lotto> lottos = new ArrayList<>()
        lottos.add(new Lotto(numbers))
        Lottos lottosCollection = new Lottos(lottos)
        WinningLotto winningLotto = WinningLotto.create(winningNumbers, bonusNumber)
        Money money = Money.create(1000)
        LottoResult lottoResult = LottoResult.create(money, lottosCollection.getPrizes(winningLotto))

        expect:
        lottoResult.getProfitRate() == result

        where:
        numbers            | winningNumbers        | bonusNumber || result
        [1, 2, 3, 4, 5, 6] | [7, 8, 9, 10, 11, 12] | 16          || 0
        [1, 2, 3, 4, 5, 6] | [1, 2, 3, 4, 5, 7]    | 16          || 150000


    }
}
