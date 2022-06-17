package strings;

import org.junit.Test;
import strings.RomanToDecimalString;

import static org.junit.Assert.assertEquals;

public class RomanToDecimalStringTest {

    private RomanToDecimalString romanToDecimalString;

    private void assertRomanNumber(String inputRomanNumberString, int expected) {
        romanToDecimalString = new RomanToDecimalString(inputRomanNumberString);
        int actual = romanToDecimalString.toDecimalValue();
        assertEquals(expected, actual);
    }

    @Test(expected = RomanToDecimalString.NoInput.class)
    public void test_NoInput() {
        new RomanToDecimalString("");
    }

    @Test(expected = RomanToDecimalString.NullInput.class)
    public void test_NullInput() {
        new RomanToDecimalString(null);
    }

    @Test(expected = Test.None.class)
    public void test_ValidCharactersInput_CauseNoException() {
        new RomanToDecimalString("VIII");
    }

    @Test(expected = RomanToDecimalString.InvalidCharactersInput.class)
    public void test_InvalidCharactersInput() {
        new RomanToDecimalString("PVIII");
    }

    @Test
    public void test_RomanToDecimal() {
        assertRomanNumber("I", 1);
    }

    @Test
    public void test_RomanToDecimal2() {
        assertRomanNumber("II", 2);
    }

    @Test
    public void test_RomanToDecimal3() {
        assertRomanNumber("III", 3);
    }

    @Test
    public void test_RomanToDecimal4() {
        assertRomanNumber("IV", 4);
    }

    @Test
    public void test_RomanToDecimal5() {
        assertRomanNumber("V", 5);
    }

    @Test
    public void test_RomanToDecimal6() {
        assertRomanNumber("IC", 99);
    }
}