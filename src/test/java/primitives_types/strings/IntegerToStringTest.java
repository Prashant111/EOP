package primitives_types.strings;

import org.junit.Assert;
import org.junit.Test;

public class IntegerToStringTest {

    private IntegerToString integerToString;

    @Test(expected = Test.None.class)
    public void test_IntegerToStringInitialisation() {
        int input = 123;
        integerToString = new IntegerToString(input);
    }

    @Test
    public void test_ConvertToString() {
        int input = 123;
        integerToString = new IntegerToString(input);
        String actual = integerToString.convertToString();
        Assert.assertEquals("123", actual);
    }

    @Test
    public void test_ConvertToString2() {
        int input = 321;
        integerToString = new IntegerToString(input);
        String actual = integerToString.convertToString();
        Assert.assertEquals("321", actual);
    }

    @Test
    public void test_ConvertExplicitPositiveNumberToString3() {
        int input = +321;
        integerToString = new IntegerToString(input);
        String actual = integerToString.convertToString();
        Assert.assertEquals("321", actual);
    }

    @Test
    public void test_ConvertZeroToString2() {
        int input = 0;
        integerToString = new IntegerToString(input);
        String actual = integerToString.convertToString();
        Assert.assertEquals("0", actual);
    }

    @Test
    public void test_ConvertNegativeToString() {
        int input = -0;
        integerToString = new IntegerToString(input);
        String actual = integerToString.convertToString();
        Assert.assertEquals("0", actual);
    }

    @Test
    public void test_ConvertNegativeToString2() {
        int input = -32133454;
        integerToString = new IntegerToString(input);
        String actual = integerToString.convertToString();
        Assert.assertEquals("-32133454", actual);
    }
}