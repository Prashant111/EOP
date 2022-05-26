package primitives_types.array;

import java.util.Arrays;
import java.util.Objects;

public class DutchFlagPartition {
    private int[] input;
    private int index;

    public DutchFlagPartition(int[] input, int index) {
        if (Objects.isNull(input))
            throw new NullInput();
        if (input.length == 0)
            throw new NoInput();
        if (index < 0)
            throw new NegativeIndex();
        if (index >= input.length)
            throw new IndexOutOfRange();
        this.input = input;
        this.index = index;
    }

    public int[] partition() {
        int pivot = input[index];
        int smaller = 0;
        int equal = 0;
        int large = input.length;
        int[] inputCopy = Arrays.copyOf(input, input.length);
        while (equal < large) {
            if (inputCopy[equal] < pivot) {
                swap(inputCopy, smaller++, equal++);
            } else if (inputCopy[equal] == pivot) {
                equal++;
            } else {
                swap(inputCopy, equal, --large);
            }
        }
        return inputCopy;
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

    public class NegativeIndex extends RuntimeException {
    }

    public class IndexOutOfRange extends RuntimeException {
    }
}
