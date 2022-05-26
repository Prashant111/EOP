package primitives_types.strings;

import java.util.ArrayList;
import java.util.List;

import static primitives_types.strings.StringLookAndSayUtils.getNextLookAndSayNumber;

public class LookAndSayProblem {
    private final int number;

    public LookAndSayProblem(int number) {
        handleException(number);
        this.number = number;
    }

    private void handleException(int number) {
        if (number < 0)
            throw new NegativeInput();
    }

    public List<String> getLookAndSayCombination() {
        List<String> result = new ArrayList<>();
        if (number == 0)
            return result;
        result.add("1");
        for (int i = 1; i < number; i++)
            result.add(getNextLookAndSayNumber(lastNumberInList(result)));
        return result;
    }

    private String lastNumberInList(List<String> result) {
        return result.get(result.size() - 1);
    }

    public class NegativeInput extends RuntimeException {
    }
}
