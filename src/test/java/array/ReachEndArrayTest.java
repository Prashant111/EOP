package array;


import array.ReachEndArray;
import org.junit.Assert;
import org.junit.Test;

public class ReachEndArrayTest {
    private ReachEndArray reachEndArray;

    @Test(expected = ReachEndArray.NullInput.class)
    public void test_NullInput() {
        new ReachEndArray(null);
    }

    @Test(expected = ReachEndArray.NoInput.class)
    public void test_NoInput() {
        new ReachEndArray(new int[]{});
    }

    @Test
    public void test_canReachEnd() {
        reachEndArray = new ReachEndArray(new int[]{3, 3, 1, 0, 2, 0, 1});
        boolean actual = reachEndArray.canReachEnd();
        Assert.assertEquals(true, actual);
    }

    @Test
    public void test_canNotReachEnd() {
        reachEndArray = new ReachEndArray(new int[]{3, 2, 0, 0, 2, 0, 1});
        boolean actual = reachEndArray.canReachEnd();
        Assert.assertEquals(false, actual);
    }


}