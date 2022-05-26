package primitives_types.strings;

import java.util.Map;
import java.util.Objects;

public class RomanToDecimalString {
    private final String romanNumberString;

    public RomanToDecimalString(String romanNumberString) {
        handleException(romanNumberString);
        this.romanNumberString = romanNumberString;
    }

    private void handleException(String romanNumberString) {
        if (Objects.isNull(romanNumberString))
            throw new NullInput();
        if (StringUtils.isEmpty(romanNumberString))
            throw new NoInput();
        if (doesContainsNonRomanCharacters(romanNumberString)) {
            throw new InvalidCharactersInput();
        }
    }

    private static boolean doesContainsNonRomanCharacters(String romanString) {
        String romanCharactersString = "IVXLCDM";
        return romanString
                .chars()
                .mapToObj(value -> Character.toUpperCase((char) (value)))
                .anyMatch(character -> romanCharactersString.indexOf(character) == -1);
    }

    public int toDecimalValue() {
        int result;
        Map<Character, Integer> map = getRomanCharsDigitMap();
        result = map.get(StringUtils.getLastCharacterOfString(romanNumberString));
        for (int i = romanNumberString.length() - 2; i >= 0; i--) {
            char character = romanNumberString.charAt(i);
            char nextCharacter = romanNumberString.charAt(i + 1);
            if (map.get(character) < map.get(nextCharacter))
                result -= map.get(character);
            else
                result += map.get(character);
        }
        return result;
    }

    private Map<Character, Integer> getRomanCharsDigitMap() {
        return Map.of(
                'M', 1000,
                'D', 500,
                'C', 100,
                'L', 50,
                'X', 10,
                'V', 5,
                'I', 1
        );
    }

    public class NoInput extends RuntimeException {
    }

    public class NullInput extends RuntimeException {
    }

    public class InvalidCharactersInput extends RuntimeException {
    }
}
