package primitives_types.array;

import java.util.Arrays;
import java.util.Objects;

public class BifurcateEvenOdd {

    private final int[] input;

    public BifurcateEvenOdd(int[] input) {
        if (Objects.isNull(input))
            throw new NullInput();
        if (input.length == 0)
            throw new NoInput();
        this.input = input;
    }

    public int[] bifurcateEvenOdd() {
        if (input.length <= 1) {
            return input;
        }
        int[] inputCopy = Arrays.copyOf(input, input.length);
        applyBifurcation(inputCopy);
        return inputCopy;
    }

    private void applyBifurcation(int[] inputCopy) {
        int evenIndex = 0;
        int oddIndex = inputCopy.length - 1;

        while (evenIndex < oddIndex) {
            if (isEven(inputCopy[evenIndex]))
                evenIndex++;
            else
                swap(inputCopy, evenIndex, oddIndex--);
        }
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public boolean isEven(int num) {
        return (num & 1) == 0;
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

}
