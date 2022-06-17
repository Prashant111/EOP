package strings;

import java.util.Objects;

public class PalindromicString {
    private String input;

    public PalindromicString(String input) {
        handleException(input);
        this.input = input;
    }

    private void handleException(String input) {
        if (Objects.isNull(input))
            throw new NullInput();
    }

    public boolean isPalindrome() {
        int start = 0;
        int end = input.length() - 1;
        for (; start < end; start++, end--) {
            if (input.charAt(start) != input.charAt(end))
                break;
        }
        return start >= end;
    }

    public class NullInput extends RuntimeException {
    }
}
