package primitives_types.strings;

import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import static java.util.logging.Level.INFO;

public class BaseConversion {
    Logger logger = Logger.getLogger(BaseConversion.class.getPackageName());
    public static final int MAX_BASE = 36;
    public static final int MIN_BASE = 2;

    private static final String ALLOWED_LETTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String numberString;
    private final int source;
    private final int target;

    public BaseConversion(String numberString, int source, int target) {
        handleException(numberString, source, target);
        this.numberString = numberString.toUpperCase();
        this.source = source;
        this.target = target;
        logger.log(INFO, "Will convert {0} from base {1} to base {2}", new Object[]{numberString, source, target});
    }

    private void handleException(String numberString, int source, int target) {
        if ((isBaseLessThan(source, MIN_BASE) || isBaseLessThan(target, MIN_BASE))
                || (isBaseGreaterThan(source, MAX_BASE) || isBaseGreaterThan(target, MAX_BASE)))
            throw new BaseRangeInvalid();
        if (Objects.isNull(numberString))
            throw new NullInput();
        if (StringUtils.isEmpty(numberString))
            throw new NoInput();
        if (checkIfContainsOtherThanBaseSupportedDigits(numberString, source))
            throw new InputOtherThanBaseSupportedDigit();
    }

    private boolean isBaseLessThan(int base, int num) {
        return base < num;
    }

    private boolean isBaseGreaterThan(int base, int num) {
        return base > num;
    }

    public boolean checkIfContainsOtherThanBaseSupportedDigits(String input, int base) {
        String inputCopy = input.toUpperCase();
        int startRange = inputCopy.startsWith("-") ? 1 : 0;
        String allowedCharacterSubset = ALLOWED_LETTERS.substring(0, base);
        return IntStream.range(startRange, inputCopy.length())
                .boxed()
                .anyMatch(index -> allowedCharacterSubset.indexOf(inputCopy.charAt(index)) < 0);
    }

    public String getConvertedInProvidedBase() {
        if (ifBaseSame())
            return numberString;
        boolean isNegative = numberString.startsWith("-");
        String localNumberString = isNegative ? numberString.substring(1) : numberString;
        String toBase10 = convertToBase10(localNumberString, source);
        String convertBase10ToProvidedBase = convertBase10ToProvidedBase(toBase10, target);
        return isNegative ? "-" + convertBase10ToProvidedBase : convertBase10ToProvidedBase;
    }

    private String convertBase10ToProvidedBase(String localNumberString, int target) {
        StringBuilder resultBuilder = new StringBuilder();
        while (!localNumberString.equals("0")) {
            DivideOp divideOp = StringMathsUtils.divide(localNumberString, target);
            String quotient = divideOp.getQuotient();
            String reminder = divideOp.getReminder();
            resultBuilder.insert(0, ALLOWED_LETTERS.charAt(Integer.parseInt(reminder)));
            localNumberString = quotient;
        }
        return resultBuilder.toString();
    }

    private String convertToBase10(String localNumberString, int base) {
        String number = "";
        for (int i = 0; i < localNumberString.length(); i++) {
            String multiplication = StringMathsUtils.multiply(number, base);
            String num2 = String.valueOf(ALLOWED_LETTERS.indexOf(localNumberString.charAt(i)));
            number = StringMathsUtils.add(multiplication, num2);
        }
        return number;
    }

    private boolean ifBaseSame() {
        return source == target;
    }

    public class BaseRangeInvalid extends RuntimeException {
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

    public class InputOtherThanBaseSupportedDigit extends RuntimeException {
    }
}
