import lotto.domain.lotto.Lotto
import lotto.domain.lotto.LottoResult
import lotto.domain.lotto.Lottos
import lotto.domain.lotto.WinningLotto
import lotto.domain.money.Money
import spock.lang.Specification

class LottoResultTest extends Specification {

    def "수익률"() {
        given:
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto([1, 2, 3, 4, 5, 6]));
        lottos.add(new Lotto([1, 2, 3, 4, 5, 6]));
        lottos.add(new Lotto([1, 2, 3, 4, 5, 6]));
        Lottos lottosCollection = new Lottos(lottos);
        WinningLotto winningLotto = WinningLotto.create(Arrays.asList(10, 11, 12, 13, 14, 15), 16);

        Money money = Money.create(3000);

        when:
        LottoResult lottoResult = LottoResult.create(money, lottosCollection.getPrizes(winningLotto));

        then:
        lottoResult.getProfitRate() == 0
    }
}
