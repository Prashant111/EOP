package strings;

import java.util.Objects;

public class TestPalindromicity {
    private String string;

    public TestPalindromicity(String string) {
        handleException(string);
        this.string = string;
    }

    private void handleException(String string) {
        if (Objects.isNull(string))
            throw new NullInput();
    }

    private boolean characterNeitherLetterNorDigitAtIndex(int start, int end, int indexToCheck) {
        return start < end && !Character.isLetterOrDigit(string.charAt(indexToCheck));
    }

    private boolean areCaseInsensitiveCharactersSame(int start, int end) {
        return Character.toLowerCase(string.charAt(start)) != Character.toLowerCase(string.charAt(end));
    }

    public boolean isPalindrome() {
        int start = 0;
        int end = string.length() - 1;
        boolean result = true;
        while (start < end) {
            while (characterNeitherLetterNorDigitAtIndex(start, end, start)) start++;
            while (characterNeitherLetterNorDigitAtIndex(start, end, end)) end--;
            if (start < end && areCaseInsensitiveCharactersSame(start, end)) {
                result = false;
                break;
            }
            start++;
            end--;
        }
        return result;
    }

    public class NullInput extends RuntimeException {
    }
}
