package strings;

import org.junit.Test;
import strings.PalindromicString;

import static org.junit.Assert.assertEquals;

public class PalindromicStringTest {
    PalindromicString palindromicString;

    @Test(expected = Test.None.class)
    public void test_createPalindromicStringInstanceWithStringParam() {
        String input = "abcddcba";
        PalindromicString palindromicString = new PalindromicString(input);
    }

    @Test(expected = PalindromicString.NullInput.class)
    public void test_nullString() {
        String input = null;
        new PalindromicString(input);
    }

    @Test
    public void test_isPalindrome() {
        String input = "abc";
        palindromicString = new PalindromicString(input);
        boolean actual = palindromicString.isPalindrome();
        assertEquals(false, actual);
    }

    @Test
    public void test_singleLetterString() {
        String input = "a";
        palindromicString = new PalindromicString(input);
        boolean actual = palindromicString.isPalindrome();
        assertEquals(true, actual);
    }


    @Test
    public void test_isPalindromeOdd() {
        String input = "aba";
        palindromicString = new PalindromicString(input);
        boolean actual = palindromicString.isPalindrome();
        assertEquals(true, actual);
    }

    @Test
    public void test_isNotPalindrome() {
        String input = "abca";
        palindromicString = new PalindromicString(input);
        boolean actual = palindromicString.isPalindrome();
        assertEquals(false, actual);
    }

    @Test
    public void test_isNotPalindrome2() {
        String input = "abcdeddba";
        palindromicString = new PalindromicString(input);
        boolean actual = palindromicString.isPalindrome();
        assertEquals(false, actual);
    }

    @Test
    public void test_isPalindrome2() {
        String input = "abcdedcba";
        palindromicString = new PalindromicString(input);
        boolean actual = palindromicString.isPalindrome();
        assertEquals(true, actual);
    }
}