package primitives_types.strings;

import org.junit.Test;
import primitives_types.strings.StringUtils;

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
