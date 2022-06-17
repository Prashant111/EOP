package array;

import java.util.Arrays;
import java.util.Objects;


public class DuplicateSortedArray {
    private int[] input;

    public DuplicateSortedArray(int[] input) {
        handleExceptionsIfAny(input);
        this.input = input;
    }

    private void handleExceptionsIfAny(int[] numbs) {
        if (Objects.isNull(numbs))
            throw new DuplicateSortedArray.NullInput();
        if (numbs.length == 0)
            throw new DuplicateSortedArray.NoInput();
        if (havingNegativeNumber(numbs))
            throw new InputContainsNegativeNumber();
    }

    private boolean havingNegativeNumber(int[] nums) {
        for (int num : nums)
            if (num < 0)
                return true;
        return false;
    }

    public int[] duplicateSortedArray() {
        int[] inputCopy = Arrays.copyOf(input, input.length);

        int length = inputCopy.length;
        int nonDuplicatedIndex = 0;
        int i = 0;
        for (; i < length; i++)
            if (inputCopy[nonDuplicatedIndex] != inputCopy[i])
                inputCopy[++nonDuplicatedIndex] = inputCopy[i];

        for (i = nonDuplicatedIndex + 1; i < length; i++)
            inputCopy[i] = 0;

        return inputCopy;
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

    public class InputContainsNegativeNumber extends RuntimeException {
    }
}
