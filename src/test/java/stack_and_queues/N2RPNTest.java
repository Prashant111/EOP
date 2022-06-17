package stack_and_queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class N2RPNTest {

    @Test
    void givenProperString_whenExecutePerformOperation_thenShouldGetCorrectResult() {
        N2RPN n2RPN = new N2RPN("3,4, +, 2, X,1, +");
        int actual = n2RPN.eval();
        assertEquals(15, actual);
    }

    @Test
    void givenProperString_whenExecutePerformOperation_thenShouldGetCorrectResult2() {
        N2RPN n2RPN = new N2RPN("10,2,/");
        int actual = n2RPN.eval();
        assertEquals(5, actual);
    }

    @Test
    void givenProperString_whenExecutePerformOperation_thenShouldGetCorrectResult3() {
        N2RPN n2RPN = new N2RPN("10,2,/, 2, -");
        int actual = n2RPN.eval();
        assertEquals(3, actual);
    }

    @Test
    void givenImproperProperString_whenExecutePerformOperation_thenShouldThrowInvalidInputException() {
        assertThrows(N2RPN.InvalidInput.class,
                () -> {
                    N2RPN n2RPN = new N2RPN("3,4,+, 2, X,X,1, +");
                    n2RPN.eval();
                });
    }

    @Test
    void givenImproperProperString_whenExecutePerformOperation_thenShouldThrowInvalidInputException2() {
        assertThrows(N2RPN.InvalidInput.class,
                () -> {
                    N2RPN n2RPN = new N2RPN("3,3,3,X");
                    n2RPN.eval();
                });
    }

    @Test
    void givenEmptyString_whenExecutePerformOperation_thenShouldThrowInvalidInputException() {
        assertThrows(N2RPN.InvalidInput.class,
                () -> {
                    N2RPN n2RPN = new N2RPN("");
                    n2RPN.eval();
                });
    }

    @Test
    void givenNullString_whenExecutePerformOperation_thenShouldThrowInvalidInputException() {
        assertThrows(N2RPN.InvalidInput.class,
                () -> {
                    N2RPN n2RPN = new N2RPN(null);
                    n2RPN.eval();
                });
    }
}