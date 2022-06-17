package stack_and_queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N4NormalizePathNamesTest {

    private void assertPathName(String input, String expected) {
        N4NormalizePathNames n4NormalizePathNames = new N4NormalizePathNames(input);
        String actual = n4NormalizePathNames.optimizedPathName();
        assertEquals(expected, actual);
    }

    @Test
    void givenInputString_whenInstantiatingPathName_shouldCrateInstanceWithoutThrowingException() {
        assertDoesNotThrow(() -> {
            new N4NormalizePathNames("/usr");
        });
    }

    @Test
    void givenInputString_whenInstantiatingPathName_shouldCrateInstanceThrowingNullInputException() {
        assertThrows(N4NormalizePathNames.NullInput.class, () -> {
            new N4NormalizePathNames(null);
        });
    }

    @Test
    void givenAbsolutePathString_whenCallingOptimizePathName_shouldReturnOptimizedPathString() {
        assertPathName("/usr/lib/../bin/gcc", "/usr/bin/gcc");
    }

    @Test
    void givenAbsolutePath2String_whenCallingOptimizePathName_shouldReturnOptimizedPathString() {
        assertPathName("scripts//./../scripts/awkscripts/././", "scripts/awkscripts");
    }

    @Test
    void givenRelativeString_whenCallingOptimizePathName_shouldReturnOptimizedPathString() {
        assertPathName("sc//./../tc/awk/././", "tc/awk");
    }
}