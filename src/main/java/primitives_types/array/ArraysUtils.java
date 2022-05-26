package primitives_types.array;

import java.util.Objects;

public class ArraysUtils {

    private ArraysUtils() {
    }

    public static void swap(int[] numbs, int i, int j) {
        handleSwapExceptions(numbs, i, j);
        int temp = numbs[i];
        numbs[i] = numbs[j];
        numbs[j] = temp;
    }

    private static void handleSwapExceptions(int[] numbs, int i, int j) {
        if (Objects.isNull(numbs))
            throw new NullInput();

        if (numbs.length == 0)
            throw new NoInput();

        if (i < 0 || j < 0 || i >= numbs.length || j >= numbs.length)
            throw new SwapIndexRangeException();

    }

    public static class NullInput extends RuntimeException {
    }

    public static class NoInput extends RuntimeException {
    }

    public static class SwapIndexRangeException extends RuntimeException {
    }
}
