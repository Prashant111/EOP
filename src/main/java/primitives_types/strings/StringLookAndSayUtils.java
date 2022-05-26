package primitives_types.strings;

public class StringLookAndSayUtils {

    private StringLookAndSayUtils() {
    }

    public static String getNextLookAndSayNumber(String string) {
        if (StringUtils.isNullOrEmpty(string))
            return StringUtils.EMPTY;
        else if (string.length() == 1)
            return "1" + string;
        StringBuilder resultString = new StringBuilder();
        int count = 1;
        for (int index = 1; index < string.length(); index++) {
            if (string.charAt(index - 1) == string.charAt(index))
                count++;
            else {
                resultString.append(count + "" + string.charAt(index - 1));
                count = 1;
            }
        }
        resultString.append(count + "" + string.charAt(string.length() - 1));
        return resultString.toString();
    }
}
