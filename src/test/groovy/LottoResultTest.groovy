import lotto.domain.lotto.Lotto
import lotto.domain.lotto.LottoResult
import lotto.domain.lotto.Lottos
import lotto.domain.lotto.WinningLotto
import lotto.domain.money.Money
import spock.lang.Specification

class LottoResultTest extends Specification {

    def "수익률"(List<Integer> numbers, List<Integer> winningNumbers) {
        given:
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(numbers));
        Lottos lottosCollection = new Lottos(lottos);
        WinningLotto winningLotto = WinningLotto.create(winningNumbers, 16);

        Money money = Money.create(1000);

        when:
        LottoResult lottoResult = LottoResult.create(money, lottosCollection.getPrizes(winningLotto));

        then:
        lottoResult.getProfitRate() == 0

        where:
        lotto                   | winningLotto          | money         || expected
        [1,2,3,4,5,6]            []


    }
}
