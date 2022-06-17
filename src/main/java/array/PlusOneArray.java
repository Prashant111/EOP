package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlusOneArray {
    List<Integer> input;

    public PlusOneArray(List<Integer> input) {
        handleExceptionsIfAny(input);
        this.input = input;
    }

    private void handleExceptionsIfAny(List<Integer> input) {
        if (Objects.isNull(input))
            throw new NullInput();
        if (input.isEmpty())
            throw new NoInput();
        if (input.stream().anyMatch(Objects::isNull))
            throw new InputHavingNull();
        if (input.stream().anyMatch(integer -> integer < 0))
            throw new NegativeInput();
    }

    public List<Integer> plusOne() {
        List<Integer> inputCopy = new ArrayList<>(input);
        int lastIndex = inputCopy.size() - 1;
        inputCopy.set(lastIndex, inputCopy.get(lastIndex) + 1);
        for (int i = lastIndex; i > 0 && inputCopy.get(i) == 10; --i) {
            inputCopy.set(i, 0);
            inputCopy.set(i - 1, inputCopy.get(i - 1) + 1);
        }
        if (inputCopy.get(0) == 10) {
            inputCopy.set(0, 0);
            inputCopy.add(0, 1);
        }
        return inputCopy;
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

    public class InputHavingNull extends RuntimeException {
    }

    public class NegativeInput extends RuntimeException {
    }
}
