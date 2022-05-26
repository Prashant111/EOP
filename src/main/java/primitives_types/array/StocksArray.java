package primitives_types.array;

import java.util.Arrays;
import java.util.Objects;

public class StocksArray {
    private int[] input;

    public StocksArray(int[] input) {
        handleExceptions(input);
        this.input = input;
    }

    private void handleExceptions(int[] input) {
        if (Objects.isNull(input))
            throw new NullInput();
        if (input.length == 0)
            throw new NoInput();
        if (Arrays.stream(input).boxed().anyMatch(integer -> integer < 0))
            throw new NegativeStockValue();
    }

    public int maxProfitAfterBuyingAndSellingOnce() {
        int length = input.length;
        if (length == 1)
            throw new SingleDayStockValue();
        int maxProfit = 0;
        int minValue = input[0];
        for(int price : input) {
            maxProfit = Math.max(maxProfit, price - minValue);
            minValue = Math.min(minValue, price);
        }
        return maxProfit;
    }

    public int maxProfitAfterBuyingAndSellingManyTimes() {
        int length = input.length;
        if (length == 1)
            throw new SingleDayStockValue();
        int profit = 0;
        for (int i = 1; i < length; i++) {
            if(input[i] > input[i - 1])
                profit += (input[i] - input[i - 1]);
        }
        return profit;
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

    public class NegativeStockValue extends RuntimeException {
    }

    public class SingleDayStockValue extends RuntimeException {
    }
}
