package primitives_types.strings;

import org.junit.Assert;
import org.junit.Test;

public class SinusoidalTest {
    private Sinusoidal sinusoidal;
    private String actual;

    private void assertSinusoidalString(String input, String expected) {
        sinusoidal = new Sinusoidal(input);
        actual = sinusoidal.getSinusoidalString();
        Assert.assertEquals(expected, actual);
    }


    @Test(expected = Sinusoidal.NullInput.class)
    public void test_nullInput() {
        new Sinusoidal(null);
    }

    @Test
    public void providedEmptyString_getEmptyStringAsResult() {
        assertSinusoidalString(StringUtils.EMPTY, StringUtils.EMPTY);
    }

    @Test
    public void providedSingleCharacterString_getSameCharacterStringAsResult() {
        assertSinusoidalString("a", "a");
    }

    @Test
    public void providedString_getCorrectResult() {
        assertSinusoidalString("Hello world", "e lHlowrdlo");
    }
}
