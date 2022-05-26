package primitives_types.strings;

public class NumberToExcelRowSheet {
    private static final String HASH = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final int rowNumber;

    public NumberToExcelRowSheet(int rowNumber) {
        handleException(rowNumber);
        this.rowNumber = rowNumber;
    }

    private void handleException(int rowNumber) {
        if (rowNumber <= 0)
            throw new NonPositiveRowNumber();
    }

    public String getExcelColumn() {
        int number = rowNumber;
        StringBuilder sb = new StringBuilder();
        while (number-- > 0) {
            int index = number % HASH.length();
            sb.insert(0, HASH.charAt(index));
            number /= HASH.length();
        }
        return sb.toString();
    }

    public class NonPositiveRowNumber extends RuntimeException {
    }
}
