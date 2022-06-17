package strings;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidIPAddresses {
    private final String string;

    public ValidIPAddresses(String string) {
        handleException(string);
        this.string = string;
    }

    private void handleException(String string) {
        if (Objects.isNull(string))
            throw new NullInput();
    }

    public List<String> generateIpAddresses() {
        List<String> result = new ArrayList<>();
        if (!validIPAddressLength(string))
            return emptyList();
        for (int i = 0; i <= 3 && i < string.length(); i++) {
            boolean isValid = isValidField(string.substring(0, i));
            if (isValid) {
                for (int j = 1; j <= 3 && i + j < string.length(); j++) {
                    isValid = isValidField(string.substring(i, i + j));
                    if (isValid) {
                        for (int k = 1; k <= 3 && i + j + k < string.length(); k++) {
                            boolean isValidField3 = isValidField(string.substring(i + j, i + j + k));
                            boolean isValidField4 = isValidField(string.substring(i + j + k));
                            if (isValidField3 && isValidField4) {
                                result.add(String.format("%s.%s.%s.%s", string.substring(0, i), string.substring(i, i + j), string.substring(i + j, i + j + k), string.substring(i + j + k)));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isValidField(String string) {
        return validFieldLength(string)
                && !(string.startsWith("0") && string.length() > 1)
                && Integer.parseInt(string) <= 256;
    }

    @NotNull
    private List<String> emptyList() {
        return List.of();
    }

    private static boolean validIPAddressLength(String string) {
        return string.length() >= 4 && string.length() <= 12;
    }

    private static boolean validFieldLength(String string) {
        return string.length() >= 1 && string.length() <= 3;
    }

    public class NullInput extends RuntimeException {
    }
}
