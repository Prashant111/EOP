package strings;

import org.junit.Test;
import strings.FirstOccurenceOfSubstring;
import strings.StringUtils;

import static org.junit.Assert.assertEquals;

public class FirstOccurenceOfSubstringTest {

    private void assertContainsString(String text, String searchString, boolean expected) {
        FirstOccurenceOfSubstring firstOccurenceOfSubstring = new FirstOccurenceOfSubstring(text, searchString);
        boolean actual = firstOccurenceOfSubstring.containsString();
        assertEquals(expected, actual);
    }

    @Test(expected = FirstOccurenceOfSubstring.NullInput.class)
    public void test_nullSearchString() {
        new FirstOccurenceOfSubstring(null, "Some random text");
    }

    @Test(expected = FirstOccurenceOfSubstring.NullInput.class)
    public void test_nullText() {
        new FirstOccurenceOfSubstring("Some random text", null);
    }

    @Test(expected = FirstOccurenceOfSubstring.NullInput.class)
    public void test_nullTextAndNullSearchString() {
        new FirstOccurenceOfSubstring(null, null);
    }

    @Test
    public void test_bothEmptyTextAndSearchString() {
        assertContainsString(StringUtils.EMPTY, StringUtils.EMPTY, true);
    }

    @Test
    public void test_EmptyTextAndNonEmptySearchString() {
        assertContainsString(StringUtils.EMPTY, "Some Random Text", false);
    }

    @Test
    public void test_NonEmptyTextAndEmptySearchString() {
        assertContainsString("Some Random Text", StringUtils.EMPTY, true);
    }

    @Test
    public void test_BothSameStrings() {
        assertContainsString("Some Random Text", "Some Random Text", true);
    }

    @Test
    public void test_DoesNotContainsStrings() {
        assertContainsString("Some Random Text", "Some Second Random Text", false);
    }

    @Test
    public void test_DoesNotContainsStrings2() {
        assertContainsString("Some Second Random Text", "Some Random Text", false);
    }

    @Test
    public void test_ContainsStrings() {
        assertContainsString("Some Second Random Text", "Some Secon", true);
    }

    @Test
    public void test_ContainsStrings2() {
        assertContainsString("Some Second Random Text", "nd Random Text", true);
    }

    @Test
    public void test_ContainsStrings3() {
        assertContainsString("Some Second Random Text", "nd Random Tex", true);
    }
}