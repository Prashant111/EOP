package primitives_types.strings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseWordsTest {

    private ReverseWords reverseWords;

    @Before
    public void setUp() throws Exception {
    }

    private void assertReverseWords(String inputString, String expected) {
        reverseWords = new ReverseWords(inputString);
        String actual = reverseWords.reverseWords();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_ReverseWords() {
        assertReverseWords("abc def ghi", "ghi def abc");
    }

    @Test
    public void test_ReverseWords2() {
        assertReverseWords("Alice likes Bob", "Bob likes Alice");
    }

    @Test
    public void test_ReverseWords3() {
        assertReverseWords("ram is costly", "costly is ram");
    }

    @Test(expected = ReverseWords.NullInput.class)
    public void test_NoInput() {
        new ReverseWords(null);
    }
}