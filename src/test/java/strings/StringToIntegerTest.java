package strings;

import org.junit.Test;
import strings.StringToInteger;

import static org.junit.Assert.assertEquals;

public class StringToIntegerTest {

    private StringToInteger stringToInteger;

    @Test(expected = StringToInteger.NullInput.class)
    public void test_nullInput() {
        new StringToInteger(null);
    }

    @Test(expected = StringToInteger.NoInput.class)
    public void test_noInput() {
        stringToInteger = new StringToInteger("");
        stringToInteger.convertToInteger();
    }

    @Test(expected = StringToInteger.InputContainsOtherThanDigitInput.class)
    public void test_otherThanDigitInput() {
        stringToInteger = new StringToInteger("4223f325");
        stringToInteger.convertToInteger();
    }

    @Test(expected = StringToInteger.InputContainsOtherThanDigitInput.class)
    public void test_otherThanDigitInputWithNegativeNumber() {
        stringToInteger = new StringToInteger("-4223f325");
        stringToInteger.convertToInteger();
    }

    @Test(expected = StringToInteger.InvalidInput.class)
    public void test_onlyNegativeSign() {
        stringToInteger = new StringToInteger("-");
        stringToInteger.convertToInteger();
    }

    @Test
    public void test_oneDigit() {
        stringToInteger = new StringToInteger("1");
        int actual = stringToInteger.convertToInteger();
        assertEquals(1, actual);
    }

    @Test
    public void test_twoDigit() {
        stringToInteger = new StringToInteger("34");
        int actual = stringToInteger.convertToInteger();
        assertEquals(34, actual);
    }

    @Test
    public void test_idealScenario() {
        stringToInteger = new StringToInteger("4234425");
        int actual = stringToInteger.convertToInteger();
        assertEquals(4234425, actual);
    }

    @Test
    public void test_negativeNumber() {
        stringToInteger = new StringToInteger("-435323");
        int actual = stringToInteger.convertToInteger();
        assertEquals(-435323, actual);
    }

    @Test(expected = StringToInteger.OutOfIntegerRange.class)
    public void test_outOfIntegerRangeScenario() {
        stringToInteger = new StringToInteger("423343234425");
        stringToInteger.convertToInteger();
    }
}