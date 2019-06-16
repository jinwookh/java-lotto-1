package lotto.domain.lotto.generator;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {
    private static final String SEPERATOR = ",";
    private List<String> manualLottosInput;

    public ManualLottoGenerator(List<String> manualLottosInput) {
        this.manualLottosInput = manualLottosInput;
    }

    @Override
    public Lottos generate() {
        List<List<Integer>> manualLottoNumbers = parseManualLottosInput();

        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> manualLotto : manualLottoNumbers) {
            lottos.add(new Lotto(manualLotto));
        }

        return new Lottos(lottos);
    }

    private List<List<Integer>> parseManualLottosInput() {
        List<List<Integer>> manualLottos = new ArrayList<>();
        for (String manualLottosInput : manualLottosInput) {
            List<String> parsedManualLottosInput = Arrays.asList(manualLottosInput.split(SEPERATOR));
            List<Integer> manualLotto
                    = parsedManualLottosInput.stream().map(string ->
                    Integer.parseInt(string)).collect(Collectors.toList());
            manualLottos.add(manualLotto);
        }
        return manualLottos;
    }
}
