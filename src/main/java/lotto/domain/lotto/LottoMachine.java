package lotto.domain.lotto;

import lotto.domain.lotto.generator.AutomaticLottoGenerator;
import lotto.domain.lotto.generator.LottoGenerator;
import lotto.domain.lotto.generator.ManualLottoGenerator;
import lotto.domain.money.Money;

import java.util.List;

public class LottoMachine {
    public static Lottos generateLottos(List<String> manualLottosInput, Money money) {
        LottoGenerator manualLottoGenerator = new ManualLottoGenerator(manualLottosInput);
        Lottos manualLottos = manualLottoGenerator.generate();

        LottoGenerator autoLottoGenerator =
                new AutomaticLottoGenerator
                        (money.getLottoCount() - manualLottos.size());

        return manualLottos.append(autoLottoGenerator.generate());
    }
}
