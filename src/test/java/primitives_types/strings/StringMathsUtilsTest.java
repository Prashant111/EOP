package primitives_types.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringMathsUtilsTest {

    @Test
    public void test_getQuotient1() {
        DivideOp divideOp = StringMathsUtils.divide("10",1);
        assertEquals("10",divideOp.getQuotient());
    }

    @Test
    public void test_getQuotient2() {
        DivideOp divideOp = StringMathsUtils.divide("10", 2);
        assertEquals("5", divideOp.getQuotient());
    }

    @Test
    public void test_getQuotient3() {
        DivideOp divideOp = StringMathsUtils.divide("10", 3);
        assertEquals("3", divideOp.getQuotient());
    }

    @Test
    public void test_getQuotient4() {
        DivideOp divideOp = StringMathsUtils.divide("10", 4);
        assertEquals("2", divideOp.getQuotient());
    }

    @Test
    public void test_getQuotient5() {
        DivideOp divideOp = StringMathsUtils.divide("10", 5);
        assertEquals("2", divideOp.getQuotient());
    }

    @Test
    public void test_getQuotient6() {
        DivideOp divideOp = StringMathsUtils.divide("10", 6);
        assertEquals("1", divideOp.getQuotient());
    }

    @Test
    public void test_getQuotient7() {
        DivideOp divideOp = StringMathsUtils.divide("10", 10);
        assertEquals("1", divideOp.getQuotient());
    }

    @Test
    public void test_getQuotient8() {
        DivideOp divideOp = StringMathsUtils.divide("10", 11);
        assertEquals("0", divideOp.getQuotient());
    }

    @Test
    public void test_getQuotient9() {
        DivideOp divideOp = StringMathsUtils.divide("10", 12);
        assertEquals("0", divideOp.getQuotient());
    }

    @Test
    public void test_add_Both_null() {
        String add = StringMathsUtils.add(null, null);
        assertEquals("0", add);
    }
}