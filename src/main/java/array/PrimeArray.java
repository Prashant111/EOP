package array;

import java.util.ArrayList;
import java.util.List;

public class PrimeArray {
    private int input;

    public PrimeArray(int input) {
        handleException(input);
        this.input = input;
    }

    private void handleException(int input) {
        if (input < 0)
            throw new NegativeInput();
    }

    public int[] createPrimeNumbers() {
        List<Integer> primes = new ArrayList<>();
        int start = 2;
        for (int n = start; n <= input; n++) {
            boolean prime = true;
            int i = 2;
            while (i <= n / 2) {
                if (n % i == 0) {
                    prime = false;
                    break;
                }
                ++i;
            }
            if (prime)
                primes.add(n);
        }
        return primes.stream().mapToInt(value -> value).toArray();
    }

    public class NegativeInput extends RuntimeException {
    }
}
