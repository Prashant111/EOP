package primitives_types.strings;

import org.junit.Assert;
import org.junit.Test;

public class StringLookAndSayUtilsTest {

    @Test
    public void test_getNextNumber_nullInput() {
        String nextLookAndSayNumber = StringLookAndSayUtils.getNextLookAndSayNumber(null);
        Assert.assertEquals("", nextLookAndSayNumber);
    }

    @Test
    public void test_getNextNumber_emptyStringInput() {
        String nextLookAndSayNumber = StringLookAndSayUtils.getNextLookAndSayNumber("");
        Assert.assertEquals("", nextLookAndSayNumber);
    }

    @Test
    public void test_getNextNumber() {
        String nextLookAndSayNumber = StringLookAndSayUtils.getNextLookAndSayNumber("1");
        Assert.assertEquals("11", nextLookAndSayNumber);
    }

    @Test
    public void test_getNextNumber2() {
        String nextLookAndSayNumber = StringLookAndSayUtils.getNextLookAndSayNumber("11");
        Assert.assertEquals("21", nextLookAndSayNumber);
    }

    @Test
    public void test_getNextNumber3() {
        String nextLookAndSayNumber = StringLookAndSayUtils.getNextLookAndSayNumber("21");
        Assert.assertEquals("1211", nextLookAndSayNumber);
    }

    @Test
    public void test_getNextNumber4() {
        String nextLookAndSayNumber = StringLookAndSayUtils.getNextLookAndSayNumber("1211");
        Assert.assertEquals("111221", nextLookAndSayNumber);
    }
}