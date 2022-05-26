package primitives_types.strings;

import java.util.Objects;

public class RemoveDsAndReplaceAs {
    private char[] chars;
    private int size;

    public RemoveDsAndReplaceAs(char[] chars, int size) {
        handleException(chars, size);
        this.chars = chars;
        this.size = size;
    }

    private void handleException(char[] input, int size) {
        if (Objects.isNull(input))
            throw new NullInput();
        if (StringUtils.isEmpty(new String(input)))
            throw new NoInput();
        if (size < 0 || size > input.length)
            throw new InvalidSizeRange();
    }

    public int replaceAndRemove() {
        int writeIdx = 0;
        int aCount = 0;
        for (int i = 0; i < size; i++) {
            if (chars[i] != 'b')
                chars[writeIdx++] = chars[i];
            if (chars[i] == 'a')
                aCount++;
        }
        int curIdx = writeIdx - 1;
        writeIdx = writeIdx + aCount - 1;

        final int finalSize = writeIdx + 1;

        while (curIdx >= 0) {
            if (chars[curIdx] == 'a') {
                chars[writeIdx--] = 'd';
                chars[writeIdx--] = 'd';
            } else {
                chars[writeIdx--] = chars[curIdx];
            }
            --curIdx;
        }
        return finalSize;

    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

    public class InvalidSizeRange extends RuntimeException {
    }

}
