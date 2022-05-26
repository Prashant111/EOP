package primitives_types.strings;

import java.util.Objects;

public class StringUtils {
    public static final String EMPTY = "";

    private StringUtils() {
    }

    public static boolean isEmpty(String input) {
        if (Objects.isNull(input))
            throw new NullInput();
        return input.length() == 0;
    }

    public static boolean isNullOrEmpty(String input) {
        return Objects.isNull(input) || isEmpty(input);
    }

    public static char getLastCharacterOfString(String string) {
        return string.charAt(string.length() - 1);
    }

    public static class NullInput extends RuntimeException {
    }
}
