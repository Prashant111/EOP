package strings;

import java.util.*;
import java.util.stream.IntStream;

public class PhoneMnemonics {
    private String inputDigit;

    private void handleException(String inputDigit) {
        if (Objects.isNull(inputDigit))
            throw new NullInput();
        if (containsOtherThanDigit(inputDigit))
            throw new InvalidInput();
    }

    private boolean containsOtherThanDigit(String inputDigit) {
        return IntStream.range(0, inputDigit.length()).boxed().anyMatch(index -> !Character.isDigit(inputDigit.charAt(index)));
    }

    public PhoneMnemonics(String inputDigit) {
        handleException(inputDigit);
        this.inputDigit = inputDigit;
    }

    public List<String> allMnemonics() {
        List<String> result = new ArrayList<>();
        Map<Character, String> characterStringMap = getPhoneNumericMapping();
        allMnemonicsHelper(0, inputDigit, characterStringMap, result, new StringBuilder());
        return result;
    }

    private void allMnemonicsHelper(int index,
                                    String inputDigit,
                                    Map<Character, String> characterStringMap,
                                    List<String> result,
                                    StringBuilder currentStringBuilder) {
        if (currentStringBuilder.length() == inputDigit.length()) {
            result.add(currentStringBuilder.toString());
        } else {
            String inputString = characterStringMap.get(inputDigit.charAt(index));
            for (int i = 0; i < inputString.length(); i++) {
                currentStringBuilder.append(inputString.charAt(i));
                allMnemonicsHelper(index + 1, inputDigit, characterStringMap, result, currentStringBuilder);
                currentStringBuilder.deleteCharAt(currentStringBuilder.length() - 1);
            }
        }
    }

    private Map<Character, String> getPhoneNumericMapping() {
        Map<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "ABC");
        map.put('3', "DEF");
        map.put('4', "GHI");
        map.put('5', "JKL");
        map.put('6', "MNO");
        map.put('7', "PQRS");
        map.put('8', "TUV");
        map.put('9', "WXYZ");
        return map;
    }

    public class NullInput extends RuntimeException {
    }

    public class InvalidInput extends RuntimeException {
    }
}
