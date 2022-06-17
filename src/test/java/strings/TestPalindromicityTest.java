package strings;

import org.junit.Assert;
import org.junit.Test;
import strings.TestPalindromicity;

public class TestPalindromicityTest {
    private TestPalindromicity testPalindromicity;

    private void assertTestPalindromiticity(String string, boolean expected) {
        testPalindromicity = new TestPalindromicity(string);
        Assert.assertEquals(expected, testPalindromicity.isPalindrome());
    }

    @Test(expected = TestPalindromicity.NullInput.class)
    public void test_nullString() {
        new TestPalindromicity(null);
    }

    @Test
    public void test_isPalindromeTrue() {
        assertTestPalindromiticity("A man, a plan, a canal, Panama.", true);
    }

    @Test
    public void test_isPalindromeTrue2() {
        assertTestPalindromiticity("Able was I, ere I saw Elba!", true);
    }

    @Test
    public void test_isPalindromeFalse() {
        assertTestPalindromiticity("Ray a Ray", false);
    }
}