package primitives_types.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RunLengthEncodingTest {

    private void assertRunLengthEncoding(String input, String expected) {
        RunLengthEncoding runLengthEncoding = new RunLengthEncoding(input);
        String actual = runLengthEncoding.encode();
        assertEquals(expected, actual);
    }

    @Test(expected = Test.None.class)
    public void test_initializeRunLengthEncoding() {
        new RunLengthEncoding(StringUtils.EMPTY);
    }

    @Test(expected = RunLengthEncoding.NullInput.class)
    public void test_nullInput() {
        new RunLengthEncoding(null);
    }

    @Test
    public void test_noInput() {
        assertRunLengthEncoding(StringUtils.EMPTY, StringUtils.EMPTY);
    }

    @Test
    public void whenNoRepeatedCharacter_resultInto1PrependedToEachCharacter() {
        assertRunLengthEncoding("abadfdsd", "1a1b1a1d1f1d1s1d");
    }

    @Test
    public void whenOneCharacterRepeatedCharacter_resultInto2PrependedToRepeatedCharacterOthersFollowSameBehavior() {
        assertRunLengthEncoding("abaddfdsd", "1a1b1a2d1f1d1s1d");
    }

    @Test
    public void whenOneCharacterRepeatedThriceCharacter_resultInto3PrependedToRepeatedCharacterOthersFollowSameBehavior() {
        assertRunLengthEncoding("abadddfdsd", "1a1b1a3d1f1d1s1d");
    }

    @Test
    public void whenSingleCharacter_resultOnePrepended() {
        assertRunLengthEncoding("a", "1a");
    }

    @Test
    public void whenTwoDifferentCharacter_resultOnePrependedToEach() {
        assertRunLengthEncoding("ab", "1a1b");
    }

    @Test
    public void whenTwoSameCharacters_resultTwoPrependedToThatCharacter() {
        assertRunLengthEncoding("aa", "2a");
    }

    @Test
    public void whenMultipleRepeatingDifferentCharacters_resultCountedNumberPrependedToThoseCharacters() {
        assertRunLengthEncoding("aaaabbbbaaaa", "4a4b4a");
    }

    @Test
    public void whenSameCharacterRepeatedManyTimes_resultCountAndCharacterOfThatNumber() {
        assertRunLengthEncoding("aaaaaaaa", "8a");
    }
}