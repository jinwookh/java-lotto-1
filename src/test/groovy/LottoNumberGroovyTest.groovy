

import lotto.domain.lotto.LottoNumber
import lotto.domain.lotto.exception.IllegalLottoNumberException
import spock.lang.Specification

class LottoNumberGroovyTest extends Specification{
    def "lottoNumber 생성"() {
        when:
        LottoNumber lottoNumber = new LottoNumber(3);

        then:
        lottoNumber.equals(new LottoNumber(3))
    }

    def "숫자 넘은 로또넘버"() {
        when:
        LottoNumber lottoNumber = new LottoNumber(46);

        then:
        thrown(IllegalLottoNumberException)
    }

    def "최소에 도달하지 못한 로또넘버"() {
        when:
        LottoNumber lottoNumber = new LottoNumber(0);

        then:
        thrown(IllegalLottoNumberException)
    }


}
