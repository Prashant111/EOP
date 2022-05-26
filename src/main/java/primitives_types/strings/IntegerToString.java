package primitives_types.strings;

public class IntegerToString {

    private final int input;

    public IntegerToString(int input) {
        this.input = input;
    }

    public String convertToString() {
        if (input == 0)
            return "0";
        boolean isNegative = input < 0;
        int inputCopy = Math.abs(input);
        String absoluteString = constructStringFromIntegerDigitIteration(inputCopy);
        return isNegative ? "-".concat(absoluteString) : absoluteString;
    }

    private String constructStringFromIntegerDigitIteration(int inputCopy) {
        StringBuilder sb = new StringBuilder();
        while (inputCopy > 0)
            inputCopy = getInputCopy(inputCopy, sb);
        return sb.toString();
    }

    private int getInputCopy(int inputCopy, StringBuilder sb) {
        sb.insert(0, inputCopy % 10);
        inputCopy /= 10;
        return inputCopy;
    }
}
