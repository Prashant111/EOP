package strings;

import java.util.Objects;
import java.util.stream.IntStream;

public class StringToInteger {
    private String input;

    public StringToInteger(String input) {
        handleException(input);
        this.input = input;
    }

    private void handleException(String input) {
        if (Objects.isNull(input))
            throw new NullInput();
    }

    //9953462321
    public int convertToInteger() {
        if (StringUtils.isEmpty(input))
            throw new NoInput();
        else if (input.equals("-"))
            throw new InvalidInput();
        else if (checkIfContainsOtherThanDigit(input))
            throw new InputContainsOtherThanDigitInput();

        long result = 0l;
        String inputCopy = input;
        boolean isNegative = input.charAt(0) == '-';

        if (isNegative)
            inputCopy = inputCopy.substring(1);

        for (int i = 0; i < inputCopy.length(); i++) {
            result = result * 10 + Character.getNumericValue(inputCopy.charAt(i));
            if (result > Integer.MAX_VALUE)
                throw new OutOfIntegerRange();
        }
        return isNegative ? -1 * (int) result : (int) result;
    }

    public boolean checkIfContainsOtherThanDigit(String input) {
        int startRange = input.startsWith("-") ? 1 : 0;
        return IntStream.range(startRange, input.length()).boxed().anyMatch(integer -> !Character.isDigit(input.charAt(integer)));
    }

    public class NoInput extends RuntimeException {
    }

    public class NullInput extends RuntimeException {
    }

    public class InvalidInput extends RuntimeException {
    }

    public class OutOfIntegerRange extends RuntimeException {
    }

    public class InputContainsOtherThanDigitInput extends RuntimeException {
    }
}
