package primitives_types.strings;

import java.util.Objects;

public class Sinusoidal {

    private String string;

    public Sinusoidal(String empty) {
        handleException(empty);
    }

    private void handleException(String string) {
        if (Objects.isNull(string))
            throw new NullInput();
        this.string = string;
    }

    public String getSinusoidalString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < string.length(); i += 4) {
            stringBuilder.append(string.charAt(i));
        }
        for (int i = 0; i < string.length(); i += 2) {
            stringBuilder.append(string.charAt(i));
        }
        for (int i = 3; i < string.length(); i += 4) {
            stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.toString();
    }

    public class NullInput extends RuntimeException {
    }
}
