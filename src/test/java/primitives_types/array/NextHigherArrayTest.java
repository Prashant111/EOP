package primitives_types.array;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextHigherArrayTest {

    private NextHigherArray nextHigherArray;

    @Test(expected = Test.None.class)
    public void test_createNextHigherArray() {
        nextHigherArray = new NextHigherArray(List.of(1, 2, 3));
    }

    @Test(expected = NextHigherArray.NullInput.class)
    public void test_nullInput() {
        new NextHigherArray(null);
    }

    @Test(expected = NextHigherArray.NoInput.class)
    public void test_noInput() {
        new NextHigherArray(List.of());
    }

    @Test(expected = NextHigherArray.ContainsNullValue.class)
    public void test_containsNullInput() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 5, null, 3));
        new NextHigherArray(list);
    }

    @Test(expected = NextHigherArray.ContainsNegativeInput.class)
    public void test_containsNegativeInput() {
        new NextHigherArray(List.of(1, -2));
    }

    @Test(expected = NextHigherArray.TwoDigitInput.class)
    public void test_containsTwoDigitInput() {
        new NextHigherArray(List.of(1, 20));
    }

    @Test()
    public void test_findNextHigherOfSingleElement() {
        nextHigherArray = new NextHigherArray(List.of(1));
        List<Integer> expected = nextHigherArray.findNextHigherNumber();
        Assert.assertEquals(List.of(), expected);
    }

    @Test()
    public void test_findNextHigherOfAllDecreasingElements() {
        nextHigherArray = new NextHigherArray(List.of(6, 2, 1));
        List<Integer> expected = nextHigherArray.findNextHigherNumber();
        Assert.assertEquals(List.of(), expected);
    }

    @Test()
    public void test_findNextHigherOfAllDecreasingElements2() {
        nextHigherArray = new NextHigherArray(List.of(3, 2, 1));
        List<Integer> expected = nextHigherArray.findNextHigherNumber();
        Assert.assertEquals(List.of(), expected);
    }

    @Test()
    public void test_findNextHigher() {
        nextHigherArray = new NextHigherArray(List.of(1, 2, 3));
        List<Integer> expected = nextHigherArray.findNextHigherNumber();
        Assert.assertEquals(List.of(1, 3, 2), expected);
    }

    @Test()
    public void test_findNextHigher2() {
        nextHigherArray = new NextHigherArray(List.of(1, 3, 2));
        List<Integer> expected = nextHigherArray.findNextHigherNumber();
        Assert.assertEquals(List.of(2, 1, 3), expected);
    }

    @Test()
    public void test_findNextHigher3() {
        nextHigherArray = new NextHigherArray(List.of(7, 1, 0, 5, 3, 5, 3, 2));
        List<Integer> expected = nextHigherArray.findNextHigherNumber();
        Assert.assertEquals(List.of(7, 1, 0, 5, 5, 2, 3, 3), expected);
    }
}