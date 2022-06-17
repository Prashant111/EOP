package strings;

import org.junit.Test;
import strings.RemoveDsAndReplaceAs;

import static org.junit.Assert.assertEquals;

public class RemoveDsAndReplaceAsTest {

    private RemoveDsAndReplaceAs removeDsAndReplaceAs;

    @Test(expected = RemoveDsAndReplaceAs.NullInput.class)
    public void test_nullInput() {
        new RemoveDsAndReplaceAs(null, 4);
    }

    @Test(expected = RemoveDsAndReplaceAs.NoInput.class)
    public void test_noInput() {
        new RemoveDsAndReplaceAs("".toCharArray(), 4);
    }

    @Test(expected = RemoveDsAndReplaceAs.InvalidSizeRange.class)
    public void test_invalidSizeRangeInput() {
        new RemoveDsAndReplaceAs("abacd".toCharArray(), 7);
    }

    @Test
    public void test_replaceAndRemove() {
        removeDsAndReplaceAs = new RemoveDsAndReplaceAs("abacd".toCharArray(), 4);
        int actual = removeDsAndReplaceAs.replaceAndRemove();
        assertEquals(5, actual);
    }
}