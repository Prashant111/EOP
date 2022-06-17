package array;

import java.util.*;

import static java.lang.Math.max;

public class LongestConsecutiveSubsequence {

    private final int[] input;

    public LongestConsecutiveSubsequence(int[] input) {
        handleExceptions(input);
        this.input = input;

    }

    private void handleExceptions(int[] input) {
        if (Objects.isNull(input))
            throw new NullInput();
    }

    public int longestConsecutiveSubSequenceBySorting() {
        if (input.length <= 1)
            return input.length;
        else {
            int[] arr = Arrays.copyOf(input, input.length);
            Arrays.sort(arr);
            int count = 1;
            while (count < arr.length && arr[count - 1] + 1 == arr[count])
                count++;
            return count;
        }
    }

    public int longestConsecutiveSubSequenceByHash() {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : input)
            set.add(num);
        for (int i = 0; i < input.length; i++) {
            int max;
            if (set.contains(input[i] - 1))
                max = 1;
            else {
                max = 0;
                int num = input[i];
                while (set.contains(num++)) max++;
            }
            result = max(result, max);
        }
        return result;
    }

    public int longestConsecutiveSubSequenceByPriorityQueue() {
        int result = 0;
        if (input.length <= 1)
            return input.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : input)
            pq.add(num);
        int prev = pq.poll();
        int maxTillNow = 1;
        while (!pq.isEmpty()) {
            if (prev + 1 == pq.peek()) {
                while (!pq.isEmpty() && prev + 1 == pq.peek()) {
                    prev = pq.poll();
                    maxTillNow++;
                }
            } else if (prev == pq.peek()) {
                while (!pq.isEmpty() && prev == pq.peek())
                    pq.poll();
            } else if (!pq.isEmpty()) {
                prev = pq.poll();
                maxTillNow = 1;
            }
            result = Math.max(result, maxTillNow);
        }
        return result;
    }

    public class NullInput extends RuntimeException {
    }
}
