package array;

import java.util.Objects;

public class LargestSumContiguousSubArray {
    private int[] input;

    public LargestSumContiguousSubArray(int[] input) {
        handleException(input);
        this.input = input;
    }

    private void handleException(int[] input) {
        if (Objects.isNull(input))
            throw new NullInput();
    }

    public int calculate() {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int num : input) {
            maxEndingHere = maxEndingHere + num;
            if (maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
            else if (maxEndingHere < 0)
                maxEndingHere = 0;
        }
        return maxSoFar;
    }

    public class NullInput extends RuntimeException {

    }
}
