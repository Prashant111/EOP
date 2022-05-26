package primitives_types.strings;

class DivideOp {
    private String quotient;
    private String reminder;

    public DivideOp(String quotient, String reminder) {
        this.quotient = quotient;
        this.reminder = reminder;
    }

    public String getQuotient() {
        return quotient;
    }

    public String getReminder() {
        return reminder;
    }
}
