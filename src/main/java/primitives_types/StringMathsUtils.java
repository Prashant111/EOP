package primitives_types;

import org.jetbrains.annotations.NotNull;
import strings.StringUtils;

public class StringMathsUtils {

    private StringMathsUtils() {
    }

    public static DivideOp divide(String dividendString, int divisor) {
        StringBuilder result = new StringBuilder();
        StringBuilder dividend = new StringBuilder("0");
        for (int i = 0; i < dividendString.length(); i++) {
            dividend.append(dividendString.charAt(i));
            Integer integer = Integer.valueOf(dividend.toString());
            if (integer < divisor) {
                result.append(0);
            } else {
                result.append(integer / divisor);
                dividend = new StringBuilder("" + (integer - (divisor) * (integer / divisor)));
            }
        }
        return new DivideOp(
                filterIntegerEquivalent(result.toString()),
                filterIntegerEquivalent(dividend.toString())
        );
    }

    public static String multiply(@NotNull String number, int multiplyWith) {
        StringBuilder multiplicationBuilder = new StringBuilder();
        int carry = 0;
        int sum = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int singleMultiplication = Character.getNumericValue(number.charAt(i)) * multiplyWith;
            sum = (singleMultiplication + carry) % 10;
            carry = (singleMultiplication + carry) / 10;
            multiplicationBuilder.insert(0, sum);
        }
        multiplicationBuilder = carry > 0 ? multiplicationBuilder.insert(0, carry) : multiplicationBuilder;
        return multiplicationBuilder.toString();
    }

    public static String add(String num1, String num2) {
        String result;
        if (StringUtils.isNullOrEmpty(num1) && StringUtils.isNullOrEmpty(num2)) {
            result = "0";
        } else if (StringUtils.isNullOrEmpty(num1) || StringUtils.isNullOrEmpty(num2)) {
            result = StringUtils.isNullOrEmpty(num1) ? num2 : num1;
        } else {
            StringBuilder addition = new StringBuilder();
            int carry = 0;
            int sum;
            for (int n1 = num1.length() - 1, n2 = num2.length() - 1; n1 >= 0 || n2 >= 0; n1--, n2--) {
                int singleN1 = n1 >= 0 ? Character.getNumericValue(num1.charAt(n1)) : 0;
                int singleN2 = n2 >= 0 ? Character.getNumericValue(num2.charAt(n2)) : 0;
                sum = (singleN1 + singleN2 + carry) % 10;
                carry = (singleN1 + singleN2 + carry) / 10;
                addition.insert(0, sum);
            }
            if (carry > 0)
                addition.insert(0, carry);
            result = addition.toString();
        }
        return result;
    }

    private static String filterIntegerEquivalent(String numberString) {
        return replaceEmptyStringToZero(removeAllFirstZero(numberString));
    }

    private static String removeAllFirstZero(String string) {
        int i = 0;
        while (i < string.length() && string.charAt(i) == '0') i++;
        return string.substring(i);
    }

    private static String replaceEmptyStringToZero(String numberString) {
        return StringUtils.isNullOrEmpty(numberString) ? "0" : numberString;
    }
}