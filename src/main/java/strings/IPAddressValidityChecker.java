package strings;

import java.util.Objects;

public class IPAddressValidityChecker {

    private final String ipAddress;

    public IPAddressValidityChecker(String ipAddress) {
        handleException(ipAddress);
        this.ipAddress = ipAddress;
    }

    private void handleException(String ipAddress) {
        if (Objects.isNull(ipAddress))
            throw new NullInput();
        if (StringUtils.isEmpty(ipAddress))
            throw new NoInput();
        if (isInputContainsOtherThanDigitAndDot(ipAddress))
            throw new InvalidInput();
    }

    private boolean isInputContainsOtherThanDigitAndDot(String ipAddress) {
        return ipAddress
                .chars()
                .mapToObj(value -> (char) value)
                .anyMatch(
                        character ->
                                (!Character.isDigit(character) && character != '.')
                );

    }

    public boolean isValidIpAddress() {
        String[] sections = ipAddress.split("\\.");
        if (sections.length != 4)
            return false;
        for (int i = 0; i < sections.length; i++) {
            if (isSectionInvalid(sections[i]))
                return false;
        }
        return true;
    }

    private static boolean isSectionInvalid(String section) {
        int sectionLength = section.length();
        boolean sectionLengthValid = isSectionLengthValid(sectionLength);
        boolean octaveInRange = octaveInRange(Integer.parseInt(section));
        return !sectionLengthValid || !octaveInRange;
    }

    private static boolean isSectionLengthValid(int sectionLength) {
        return sectionLength >= 1 && sectionLength <= 3;
    }

    private static boolean octaveInRange(Integer octaveValue) {
        return octaveValue != null && (octaveValue >= 0 && octaveValue <= 255);
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

    public class InvalidInput extends RuntimeException {
    }
}
