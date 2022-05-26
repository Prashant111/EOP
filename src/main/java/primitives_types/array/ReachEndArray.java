package primitives_types.array;

import java.util.Objects;

public class ReachEndArray {
    private final int[] input;

    public ReachEndArray(int[] input) {
        handleException(input);
        this.input = input;
    }

    private void handleException(int[] input) {
        if (Objects.isNull(input))
            throw new ReachEndArray.NullInput();
        if (input.length == 0)
            throw new ReachEndArray.NoInput();
    }

    public boolean canReachEnd() {
        int maximumIndex = 0;
        int maxIndex = input.length - 1;
        for (int i = 0; maximumIndex < maxIndex && i <= maximumIndex; i++)
            maximumIndex = Math.max(maximumIndex, i + input[i]);
        return maximumIndex >= maxIndex;
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }
}
