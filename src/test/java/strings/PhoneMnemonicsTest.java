package strings;

import org.junit.Test;
import strings.PhoneMnemonics;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PhoneMnemonicsTest {

    private PhoneMnemonics phoneMnemonics;

    @Test(expected = PhoneMnemonics.NullInput.class)
    public void test_nullInput() {
        new PhoneMnemonics(null);
    }

    @Test(expected = PhoneMnemonics.InvalidInput.class)
    public void test_otherThanDigitInput() {
        new PhoneMnemonics("1a");
    }

    @Test
    public void test_allMnemonics1() {
        assertAllMnemonics("2", List.of("A", "B", "C"));
    }

    private void assertAllMnemonics(String inputString, List<String> expected) {
        phoneMnemonics = new PhoneMnemonics(inputString);
        List<String> actual = phoneMnemonics.allMnemonics();
        assertEquals(expected, actual);
    }

    @Test
    public void test_allMnemonics2() {
        assertAllMnemonics("9", List.of("W", "X", "Y", "Z"));
    }

    @Test
    public void test_allMnemonics3() {
        assertAllMnemonics("23", List.of(
                "AD",
                "AE",
                "AF",
                "BD",
                "BE",
                "BF",
                "CD",
                "CE",
                "CF"
        ));
    }
}