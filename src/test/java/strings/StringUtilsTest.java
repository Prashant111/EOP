package strings;

import org.junit.Test;
import strings.StringUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    @Test(expected = StringUtils.NullInput.class)
    public void test_nullInput() {
        StringUtils.isEmpty(null);
    }

    @Test
    public void test_emptyInput() {
        assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    public void test_nonEmptyInput() {
        assertFalse(StringUtils.isEmpty("abc"));
    }
}
