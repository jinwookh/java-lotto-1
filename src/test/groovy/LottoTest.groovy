import lotto.domain.lotto.Lotto
import lotto.domain.lotto.exception.IllegalLottoNumberException
import lotto.domain.lotto.exception.IllegalNumberCombinationException
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertThrows

class LottoTest extends Specification{

    def "로또 숫자 5개"() {
        when:
        new Lotto([1,2,3,4,5,5]);

        then:
        thrown(IllegalNumberCombinationException)
    }


}
