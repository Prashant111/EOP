package primitives_types.array;

import java.util.Objects;

public class StepsArray {
    private int[] input;

    public StepsArray(int[] input) {
        handleExceptionsIfAny(input);
        this.input = input;
    }

    private void handleExceptionsIfAny(int[] numbs) {
        if (Objects.isNull(numbs))
            throw new StepsArray.NullInput();
        if (numbs.length == 0)
            throw new StepsArray.NoInput();
        if (havingNegativeNumber(numbs))
            throw new InputContainsNegativeNumber();
    }

    private boolean havingNegativeNumber(int[] nums) {
        for (int num : nums)
            if (num < 0)
                return true;
        return false;
    }

    public boolean possibleToReactEndIndex() {
        int furthestReachSoFar = 0;
        int lastIndex = input.length;
        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; i++) {
            furthestReachSoFar = Math.max(furthestReachSoFar, i + input[i]);
        }
        return furthestReachSoFar >= lastIndex;
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

    public class InputContainsNegativeNumber extends RuntimeException {
    }
}
