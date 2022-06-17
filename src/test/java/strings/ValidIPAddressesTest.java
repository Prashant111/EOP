package strings;

import org.junit.Test;
import strings.StringUtils;
import strings.ValidIPAddresses;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ValidIPAddressesTest {

    private List<String> list(String... strings) {
        return List.of(strings);
    }

    private void assertIPAddresses(String empty, List<String> strings) {
        ValidIPAddresses validIpAddresses = new ValidIPAddresses(empty);
        List<String> expected = validIpAddresses.generateIpAddresses();
        assertEquals(expected, strings);
    }

    @Test(expected = ValidIPAddresses.NullInput.class)
    public void givenNullInput_throwNullException() {
        new ValidIPAddresses(null);
    }

    @Test
    public void givenBlankString_resultEmptyArray() {
        assertIPAddresses(StringUtils.EMPTY, list());
    }

    @Test
    public void givenSmallStringNotCapableOfResultingValidIPAddress_resultEmptyList() {
        assertIPAddresses("111", list());
    }

    @Test
    public void givenFourZeros_resultEmptyList() {
        assertIPAddresses("0000", list("0.0.0.0"));
    }

    @Test
    public void givenFiveZeros_resultEmptyList() {
        assertIPAddresses("00000", list());
    }

    @Test
    public void givenLargeStringNotCapableOfResultingValidIPAddress_resultEmptyList() {
        assertIPAddresses("1111111111111", list());
    }

    @Test
    public void givenMinimumPossibleString_resultOneResult() {
        assertIPAddresses("1111", list("1.1.1.1"));
    }

    @Test
    public void givenMinimumPossibleString_resultOneResult2() {
        assertIPAddresses("1112", list("1.1.1.2"));
    }

    @Test
    public void givenFiveLengthString_resultMultipleResults() {
        assertIPAddresses("11111", list(
                "1.1.1.11",
                "1.1.11.1",
                "1.11.1.1",
                "11.1.1.1")
        );
    }

    @Test
    public void givenValidLengthString_resultMultipleResults() {
        assertIPAddresses("19216811", list(
                "1.92.168.11",
                "19.2.168.11",
                "19.21.68.11",
                "19.216.8.11",
                "19.216.81.1",
                "192.1.68.11",
                "192.16.8.11",
                "192.16.81.1",
                "192.168.1.1"
        ));
    }
}