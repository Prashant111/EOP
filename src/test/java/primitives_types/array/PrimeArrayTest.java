package primitives_types.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PrimeArrayTest {
    private PrimeArray primeArray;

    @Test(expected = PrimeArray.NegativeInput.class)
    public void test_negativeInput() {
        new PrimeArray(-3);
    }

    @Test
    public void test_positiveCase() {
        primeArray = new PrimeArray(12);
        int[] expected = primeArray.createPrimeNumbers();
        assertArrayEquals(new int[]{2, 3, 5, 7, 11}, expected);
    }

    @Test
    public void test_singleInput() {
        primeArray = new PrimeArray(3);
        int[] expected = primeArray.createPrimeNumbers();
        assertArrayEquals(new int[]{2, 3}, expected);
    }

    @Test
    public void test_zeroInput() {
        primeArray = new PrimeArray(0);
        int[] expected = primeArray.createPrimeNumbers();
        assertArrayEquals(new int[]{}, expected);
    }

}