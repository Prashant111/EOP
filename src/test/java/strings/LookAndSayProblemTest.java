package strings;

import org.junit.Assert;
import org.junit.Test;
import strings.LookAndSayProblem;

import java.util.List;

public class LookAndSayProblemTest {
    private LookAndSayProblem lookAndSayProblem;

    @Test(expected = Test.None.class)
    public void test_Initialize() {
        lookAndSayProblem = new LookAndSayProblem(1);
    }

    private void assertLookAndSayList(int singleInput, List<String> expected) {
        LookAndSayProblem lookAndSayProblem = new LookAndSayProblem(singleInput);
        List<String> actual = lookAndSayProblem.getLookAndSayCombination();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = LookAndSayProblem.NegativeInput.class)
    public void test_NegativeInput() {
        new LookAndSayProblem(-1);
    }

    @Test
    public void test_ZeroInput() {
        assertLookAndSayList(0, List.of());
    }

    @Test
    public void test_SingleInput() {
        assertLookAndSayList(1, List.of("1"));
    }

    @Test
    public void test_ValidInput() {
        assertLookAndSayList(2, List.of("1", "11"));
    }

    @Test
    public void test_ValidInput1() {
        assertLookAndSayList(3, List.of("1", "11", "21"));
    }

    @Test
    public void test_ValidInput2() {
        assertLookAndSayList(4, List.of("1", "11", "21", "1211"));
    }

    @Test
    public void test_ValidInput3() {
        assertLookAndSayList(5, List.of("1", "11", "21", "1211", "111221"));
    }

    @Test
    public void test_ValidInput4() {
        assertLookAndSayList(6, List.of("1", "11", "21", "1211", "111221", "312211"));
    }

    @Test
    public void test_ValidInput5() {
        assertLookAndSayList(7, List.of("1", "11", "21", "1211", "111221", "312211", "13112221"));
    }
}