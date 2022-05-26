package primitives_types.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class MultiplyArray {
    List<Integer> num1;
    List<Integer> num2;

    public MultiplyArray(List<Integer> num1, List<Integer> num2) {
        handleExceptionsIfAny(num1, num2);
        this.num1 = num1;
        this.num2 = num2;
    }

    private void handleExceptionsIfAny(List<Integer> num1, List<Integer> num2) {
        if (Objects.isNull(num1) || Objects.isNull(num2))
            throw new NullInput();
        if (num1.isEmpty() || num2.isEmpty())
            throw new NoInput();
        if (doesListHavingNull(num1) || doesListHavingNull(num2))
            throw new InputHavingNull();
        if (doesListHavingMoreThanTwoDigits(num1) || doesListHavingMoreThanTwoDigits(num2))
            throw new InputContainsTwoDigitNumber();
        if (containsNegativeNumberOtherThanFirst(num1) || containsNegativeNumberOtherThanFirst(num2))
            throw new NegativeInputInBetweenOfNumbers();
    }

    private boolean doesListHavingNull(List<Integer> num1) {
        return num1.stream().anyMatch(Objects::isNull);
    }

    private boolean doesListHavingMoreThanTwoDigits(List<Integer> num1) {
        return num1.stream().skip(1).anyMatch(integer -> integer > 9);
    }

    private boolean containsNegativeNumberOtherThanFirst(List<Integer> num1) {
        return num1.stream().skip(1).anyMatch(integer -> integer < 0);
    }

    public List<Integer> multiply() {
        List<Integer> result = new ArrayList<>();
        List<Integer> largerNumber;
        List<Integer> smallerNumber;
        boolean isNegative = num1.get(0) < 0 ^ num2.get(0) < 0;
        if (num1.size() >= num2.size()) {
            largerNumber = new ArrayList<>(num1);
            smallerNumber = new ArrayList<>(num2);
        } else {
            largerNumber = new ArrayList<>(num2);
            smallerNumber = new ArrayList<>(num1);
        }
        largerNumber.set(0, Math.abs(largerNumber.get(0)));
        smallerNumber.set(0, Math.abs(smallerNumber.get(0)));
        for (int num : smallerNumber) {
            result.add(0);
            List<Integer> multiplication = getMultiplication(num, largerNumber);
            result = addRowInResult(result, multiplication);
        }
        if (isNegative)
            result.set(0, -1 * result.get(0));
        return result;
    }

    private List<Integer> getMultiplication(int num, List<Integer> largerNumber) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        if (num == 0) {
            return new ArrayList<>(List.of(0));
        }
        if (num == 1) {
            return new ArrayList<>(largerNumber);
        }
        for (int i = largerNumber.size() - 1; i >= 0; i--) {
            int mul = (num * largerNumber.get(i) + carry);
            result.add(0, mul % 10);
            carry = mul / 10;
        }
        if (carry > 0) {
            result.add(0, carry);
        }
        return result;
    }

    private List<Integer> addRowInResult(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list1Copy = new ArrayList<>(list1);
        List<Integer> list2Copy = new ArrayList<>(list2);
        int diff = list1Copy.size() - list2Copy.size();
        if (diff > 0) {
            IntStream.range(0, Math.abs(diff)).boxed().forEach(integer -> list2Copy.add(0, 0));
        } else if (diff < 0) {
            IntStream.range(0, Math.abs(diff)).boxed().forEach(integer -> list1Copy.add(0, 0));
        }
        int carry = 0;
        for (int i = list1Copy.size() - 1; i >= 0; i--) {
            int sum = list1Copy.get(i) + list2Copy.get(i) + carry;
            result.add(0, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0)
            result.add(0, carry);
        return result;
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

    public class InputHavingNull extends RuntimeException {
    }

    public class InputContainsTwoDigitNumber extends RuntimeException {
    }

    public class NegativeInputInBetweenOfNumbers extends RuntimeException {
    }
}
