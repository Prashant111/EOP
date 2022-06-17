package strings;

import org.junit.Before;
import org.junit.Test;
import strings.IPAddressValidityChecker;
import strings.StringUtils;

import static org.junit.Assert.assertEquals;

public class IPAddressValidityCheckerTest {

    private IPAddressValidityChecker ipAddressValidityChecker;
    private String validIP;

    @Before
    public void setUp() throws Exception {
        validIP = "255.255.0.0";
    }

    private void assertIPValidation(String validIP, boolean expected) {
        IPAddressValidityChecker IPAddressValidityChecker = new IPAddressValidityChecker(validIP);
        boolean actual = IPAddressValidityChecker.isValidIpAddress();
        assertEquals(expected, actual);
    }

    @Test(expected = IPAddressValidityChecker.NullInput.class)
    public void test_nullInput() {
        new IPAddressValidityChecker(null);
    }

    @Test(expected = IPAddressValidityChecker.NoInput.class)
    public void test_noInput() {
        new IPAddressValidityChecker(StringUtils.EMPTY);
    }

    @Test(expected = IPAddressValidityChecker.InvalidInput.class)
    public void test_invalidInput() {
        new IPAddressValidityChecker("123.215.124.1k3");
    }

    @Test(expected = Test.None.class)
    public void testNoException_forValidIP() {
        new IPAddressValidityChecker(validIP);
    }

    @Test
    public void test_ValidIPAddress1() {
        assertIPValidation(validIP, true);
    }

    @Test
    public void test_ValidIPAddress2() {
        assertIPValidation("125.1.3.0", true);
    }

    @Test
    public void test_InvalidValidIPAddress() {
        assertIPValidation("125.1.3", false);
    }

    @Test
    public void test_InvalidIPAddress1() {
        assertIPValidation("256.1.3.0", false);
    }
}
