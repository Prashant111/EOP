package strings;

import java.util.Objects;

public class ExcelRowToNumberSheet {
    private final String rowText;

    public ExcelRowToNumberSheet(String rowText) {
        handleException(rowText);
        this.rowText = rowText;
    }

    private void handleException(String rowText) {
        if (Objects.isNull(rowText))
            throw new NullInput();
        if (StringUtils.isEmpty(rowText))
            throw new NoInput();
    }

    public int getRowNumber() {
        int solution = 0;
        String row = rowText;
        for (int i = 0; i < row.length(); i++)
            solution = solution * 26 + row.charAt(i) - 'A' + 1;
        return solution;
    }

    public class NullInput extends RuntimeException {
    }

    public class NoInput extends RuntimeException {
    }

}
