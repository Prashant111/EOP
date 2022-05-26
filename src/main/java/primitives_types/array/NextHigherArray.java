package primitives_types.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class NextHigherArray {
    private final List<Integer> input;

    public NextHigherArray(List<Integer> input) {
        handleException(input);
        this.input = input;
    }

    private void handleException(List<Integer> input) {
        if (Objects.isNull(input))
            throw new NullInput();
        if (input.isEmpty())
            throw new NoInput();
        if (input.stream().anyMatch(Objects::isNull))
            throw new ContainsNullValue();
        if (input.stream().anyMatch(integer -> integer < 0))
            throw new ContainsNegativeInput();
        if (input.stream().anyMatch(integer -> integer > 9))
            throw new TwoDigitInput();
    }

    public List<Integer> findNextHigherNumber() {
        List<Integer> result = new ArrayList<>(input);
        int size = result.size();
        int k = size - 2;
        for (; k >= 0; k--)
            if (result.get(k) < result.get(k + 1))
                break;

        if (k == -1)
            return Collections.emptyList();

        for (int i = size - 1; i > k; i--)
            if (result.get(i) > result.get(k)) {
                Collections.swap(result, k, i);
                break;
            }

        Collections.reverse(result.subList(k + 1, size));
        return result;
    }

    public class NoInput extends RuntimeException {
    }

    public class NullInput extends RuntimeException {
    }

    public class ContainsNegativeInput extends RuntimeException {
    }

    public class ContainsNullValue extends RuntimeException {
    }

    public class TwoDigitInput extends RuntimeException {
    }
}
