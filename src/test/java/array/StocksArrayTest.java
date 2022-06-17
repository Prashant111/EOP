package array;

import array.StocksArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StocksArrayTest {
    private StocksArray stocksArray;

    @Test(expected = StocksArray.NullInput.class)
    public void test_NullInput() {
        new StocksArray(null);
    }

    @Test(expected = StocksArray.NoInput.class)
    public void test_NoInput() {
        new StocksArray(new int[]{});
    }

    @Test(expected = StocksArray.NegativeStockValue.class)
    public void test_NegativeStockInput() {
        new StocksArray(new int[]{20, 30, 5, -10, 3});
    }

    @Test(expected = StocksArray.SingleDayStockValue.class)
    public void test_SingleDayInput() {
        StocksArray stocksArray = new StocksArray(new int[]{1});
        stocksArray.maxProfitAfterBuyingAndSellingOnce();
    }

    @Test
    public void test_maxProfit_1() {
        int input[] = new int[]{1, 100};
        stocksArray = new StocksArray(input);
        int actual = stocksArray.maxProfitAfterBuyingAndSellingOnce();
        assertEquals(99, actual);
    }

    @Test
    public void test_maxProfit_2() {
        int input[] = new int[]{0, 5, 0, 20, 0, 10, 30, 0, 25, 20};
        stocksArray = new StocksArray(input);
        int actual = stocksArray.maxProfitAfterBuyingAndSellingOnce();
        assertEquals(30, actual);
    }

    @Test
    public void test_maxProfitForAddDecreasingValue() {
        int input[] = new int[]{30, 20, 10};
        stocksArray = new StocksArray(input);
        int actual = stocksArray.maxProfitAfterBuyingAndSellingOnce();
        assertEquals(0, actual);
    }

    @Test
    public void test_profitForSellingManyTimes() {
        int input[] = new int[]{1, 10, 21, 10, 20};
        stocksArray = new StocksArray(input);
        int actual = stocksArray.maxProfitAfterBuyingAndSellingManyTimes();
        assertEquals(30, actual);
    }

    @Test(expected = StocksArray.SingleDayStockValue.class)
    public void test_oneDayStockDataForSellingManyTimes() {
        int input[] = new int[]{80};
        stocksArray = new StocksArray(input);
        stocksArray.maxProfitAfterBuyingAndSellingManyTimes();
    }

    @Test
    public void test_profitForAllDayDecreasingStocksValueSellingManyTimes() {
        int input[] = new int[]{7, 7, 7, 7, 7, 7, 2, 2, 0};
        stocksArray = new StocksArray(input);
        int actual = stocksArray.maxProfitAfterBuyingAndSellingManyTimes();
        assertEquals(0, actual);
    }
}