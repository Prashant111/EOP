package array;

import array.StepsArray;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StepsArrayTest {
    private StepsArray stepsArray;

    @Test(expected = StepsArray.NullInput.class)
    public void test_nullInput() {
        new StepsArray(null);
    }

    @Test(expected = StepsArray.NoInput.class)
    public void test_noInput() {
        new StepsArray(new int[]{});
    }

    @Test(expected = StepsArray.InputContainsNegativeNumber.class)
    public void test_inputContainsNegativeNumber() {
        new StepsArray(new int[]{1, -1, 2});
    }

    @Test
    public void test_possibleToReactEndIndex() {
        int[] input = {3, 3, 1, 0, 2, 0, 1};
        stepsArray = new StepsArray(input);
        assertTrue(stepsArray.possibleToReactEndIndex());
    }

    @Test
    public void test_notPossibleToReactEndIndex() {
        int[] input = {3, 2, 0, 0, 2, 0, 1};
        stepsArray = new StepsArray(input);
        assertFalse(stepsArray.possibleToReactEndIndex());
    }
}