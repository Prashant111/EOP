package stack_and_queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N3WellFormedBracketsTest {

    private String nullInput;
    private String validInput;
    private String validInput2;
    private String validInput3;
    private String invalidInput;
    private String invalidInput2;
    private String invalidInput3;
    private String invalidInput4;

    @BeforeEach
    void setUp() {
        nullInput = null;
        validInput = "(){[]}";
        validInput2 = "[(){[]}]";
        validInput3 = "(){[]}[]{}([]{})";
        invalidInput = "(";
        invalidInput2 = ")";
        invalidInput3 = "[)";
        invalidInput4 = "(])";
    }

    private void assertWellFormedBrackets(String input, boolean expected) {
        N3WellFormedBrackets n3WellFormedBrackets = new N3WellFormedBrackets(input);
        boolean actual = n3WellFormedBrackets.isWellFormed();
        assertEquals(expected, actual);
    }

    @Test
    void givenNoInstance_whenCreatingInstanceWithValidData_thenShouldCreateInstanceWithoutThrowingException() {
        assertDoesNotThrow(() -> new N3WellFormedBrackets(validInput));
    }

    @Test
    void givenNoInstance_whenCreatingInstanceWithInvalidData_thenAlsoShouldCreateInstanceWithoutThrowingException() {
        assertDoesNotThrow(() -> new N3WellFormedBrackets(invalidInput));
    }

    @Test
    void givenNoInstance_whenCreatingInstanceWithNullValue_thenShouldThrowException() {
        assertThrows(N3WellFormedBrackets.NullInput.class,
                () -> new N3WellFormedBrackets(nullInput));
    }

    @Test
    void givenValidData_whenExecuteIsWellFormedMethod_shouldReturnTrue() {
        assertWellFormedBrackets(validInput, true);
    }

    @Test
    void givenValidData_whenExecuteIsWellFormedMethod_shouldReturnTrue2() {
        assertWellFormedBrackets(validInput2, true);
    }

    @Test
    void givenValidData_whenExecuteIsWellFormedMethod_shouldReturnTrue3() {
        assertWellFormedBrackets(validInput3, true);
    }

    @Test
    void givenInvalidData_whenExecuteIsWellFormedMethod_shouldReturnFalse() {
        assertWellFormedBrackets(invalidInput, false);
    }

    @Test
    void givenInvalidData_whenExecuteIsWellFormedMethod_shouldReturnFalse2() {
        assertWellFormedBrackets(invalidInput2, false);
    }

    @Test
    void givenInvalidData_whenExecuteIsWellFormedMethod_shouldReturnFalse3() {
        assertWellFormedBrackets(invalidInput3, false);
    }

    @Test
    void givenInvalidData_whenExecuteIsWellFormedMethod_shouldReturnFalse4() {
        assertWellFormedBrackets(invalidInput4, false);
    }
}