package strings;

import java.util.Objects;

public class FirstOccurenceOfSubstring {
    private final String text;
    private final String searchString;

    private void handleExceptions(String text, String searchString) {
        if (Objects.isNull(text) || Objects.isNull(searchString)) {
            throw new NullInput();
        }
    }

    public FirstOccurenceOfSubstring(String text, String searchString) {
        handleExceptions(text, searchString);
        this.searchString = searchString;
        this.text = text;
    }

    public boolean containsString() {
        boolean result = false;
        if (text.equals(StringUtils.EMPTY) || searchString.equals(StringUtils.EMPTY)) {
            if (!searchString.equals(StringUtils.EMPTY))
                result = false;
            else
                result = true;
        } else {
            int i = 0;
            while (i <= text.length() - searchString.length()) {
                int j = 0;
                while (i < text.length()
                        && j < searchString.length()
                        && text.charAt(i) == searchString.charAt(j)
                ) {
                    i++;
                    j++;
                }
                if (j == searchString.length()) {
                    result = true;
                    break;
                }
                i++;
            }
        }
        return result;
    }

    public class NullInput extends RuntimeException {
    }
}
