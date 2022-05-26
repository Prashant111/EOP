package primitives_types.array;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlusOneArrayTest {

    private PlusOneArray plusOneArray;

    @Test(expected = PlusOneArray.NullInput.class)
    public void test_NullInput() {
        plusOneArray = new PlusOneArray(null);
    }

    @Test(expected = PlusOneArray.NoInput.class)
    public void test_NoInput() {
        plusOneArray = new PlusOneArray(List.of());
    }

    @Test(expected = PlusOneArray.NegativeInput.class)
    public void test_ContainsNegativeInput() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, -4, 5));
        plusOneArray = new PlusOneArray(input);
    }

    @Test(expected = PlusOneArray.InputHavingNull.class)
    public void test_InputContainsNull() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, null, 5));
        plusOneArray = new PlusOneArray(input);
    }

    @Test
    public void test_plusOne() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        plusOneArray = new PlusOneArray(input);
        List<Integer> actual = plusOneArray.plusOne();
        assertEquals(List.of(1, 2, 3, 4, 6), actual);
    }

    @Test
    public void test_plusOneSingleInput() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0));
        plusOneArray = new PlusOneArray(input);
        List<Integer> actual = plusOneArray.plusOne();
        assertEquals(List.of(1), actual);
    }

    @Test
    public void test_plusOne_2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 9, 1, 8, 9, 9));
        plusOneArray = new PlusOneArray(input);
        List<Integer> actual = plusOneArray.plusOne();
        assertEquals(List.of(1, 9, 1, 9, 0, 0), actual);
    }

    @Test
    public void test_plusOneAll9() {
        List<Integer> input = new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9, 9));
        plusOneArray = new PlusOneArray(input);
        List<Integer> actual = plusOneArray.plusOne();
        assertEquals(List.of(1, 0, 0, 0, 0, 0, 0), actual);
    }
}