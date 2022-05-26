package primitives_types.array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

class BifurcateEvenOddTest {

    private BifurcateEvenOdd bifurcateEvenOdd;

    private void assertBifurcatedArray(int[] input, int[] actual) {
        boolean areArraysBifurcated = havingSameSetOfNumbers(input, actual)
                && areNumbersBifurcatedInEvenAndOdd(actual);
        assertTrue(areArraysBifurcated);
    }

    private boolean areNumbersBifurcatedInEvenAndOdd(int[] actual) {
        boolean isCurrentNumberOdd = false;
        for (int num : actual) {
            if (isCurrentNumberOdd && isEven(num))
                return false;
            isCurrentNumberOdd = isOdd(num);
        }
        return true;
    }

    private boolean isEven(int num) {
        return (num & 1) == 0;
    }

    private boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    private boolean havingSameSetOfNumbers(int[] input, int[] actual) {
        int[] inputCopy = Arrays.copyOf(input, input.length);
        int[] actualCopy = Arrays.copyOf(actual, actual.length);

        Arrays.sort(inputCopy);
        Arrays.sort(actualCopy);
        for (int i = 0; i < inputCopy.length; i++) {
            if (inputCopy[i] != actualCopy[i])
                return false;
        }
        return true;
    }

    private int[] arrayFromArgumentAccessor(ArgumentsAccessor argumentsAccessor) {
        int[] array = new int[argumentsAccessor.size()];
        for (int i = 0; i < argumentsAccessor.size(); i++) {
            array[i] = argumentsAccessor.getInteger(i);
        }
        return array;
    }

    @Test
    public void test_oneEvenNumber() {
        int[] input = new int[]{0};
        bifurcateEvenOdd = new BifurcateEvenOdd(input);
        int[] actual = bifurcateEvenOdd.bifurcateEvenOdd();
        assertBifurcatedArray(input, actual);
    }

    @Test
    public void test_oneOddNumber() {
        int[] input = new int[]{1};
        bifurcateEvenOdd = new BifurcateEvenOdd(input);
        int[] actual = bifurcateEvenOdd.bifurcateEvenOdd();
        assertBifurcatedArray(input, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "0, 1",
            "0, 0",
            "1, 1",
            "0, 2",
            "1, 3",
            "2, 0",
            "1, 1, 1",
            "2, 2, 2",
            "1, 3, 5",
            "2, 4, 6",
            "1, 2, 3",
            "1, 2, 4",
            "2, 3, 6",
            "3, 2, 1",
            "4, 2, 1",
            "5, 3, 2",
            "5, 3, 2, 1, 3, 4, 3456, 56, 56, 5, 34, 53, 4, 3123, 2, 434, 534, 53453, 345, 34, 523, 423, 23",
    })
    void test_numbers(ArgumentsAccessor argumentsAccessor) {
        int[] input = arrayFromArgumentAccessor(argumentsAccessor);
        bifurcateEvenOdd = new BifurcateEvenOdd(input);
        int[] actual = bifurcateEvenOdd.bifurcateEvenOdd();
        assertBifurcatedArray(input, actual);
    }

    @Test
    public void test_NullInput() {
        assertThrows(
                BifurcateEvenOdd.NullInput.class,
                () -> {
                    new BifurcateEvenOdd(null);
                }
        );
    }

    @Test
    public void test_NoInput() {
        assertThrows(
                BifurcateEvenOdd.NoInput.class,
                () -> {
                    new BifurcateEvenOdd(new int[]{});
                }
        );
    }
}