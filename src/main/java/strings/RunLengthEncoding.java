package strings;

import java.util.Objects;

public class RunLengthEncoding {
    private String string;

    public RunLengthEncoding(String string) {
        handleException(string);
        this.string = string;
    }

    private void handleException(String string) {
        if (Objects.isNull(string))
            throw new NullInput();
    }

    public String encode() {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isEmpty(string))
            return StringUtils.EMPTY;
        else {
            int i = 0;
            while (i < string.length()) {
                int mark = i;
                while (i < string.length() - 1 && string.charAt(i) == string.charAt(i + 1)) i++;
                sb.append(counterAndCharacter(i, mark));
                i++;
            }
        }
        return sb.toString();
    }

    private String counterAndCharacter(int i, int mark) {
        return (i - mark + 1) + "" + string.charAt(i);
    }

    public class NullInput extends RuntimeException {

    }
}
