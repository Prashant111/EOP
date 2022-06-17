package strings;

import java.util.Objects;

public class ReverseWords {
    private String string;

    public ReverseWords(String string) {
        handleException(string);
        this.string = string;
    }

    private void handleException(String string) {
        if (Objects.isNull(string))
            throw new NullInput();
    }

    public String reverseWords() {
        String stringInput = string;
        int start = 0;
        for (int i = 0; i < stringInput.length(); i++) {
            if (Character.isSpaceChar(stringInput.charAt(i))) {
                stringInput = reversePart(stringInput, start, i - 1);
                start = i + 1;
            }
        }
        stringInput = reversePart(stringInput, start, stringInput.length() - 1);
        return reversePart(stringInput, 0, stringInput.length() - 1);
    }

    private String reversePart(String stringInput, int start, int end) {
        char[] chars = stringInput.toCharArray();
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }


    public class NullInput extends RuntimeException {

    }
}
