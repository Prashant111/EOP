package stack_and_queues;

import java.util.Objects;

public class N3WellFormedBrackets {
    private static final String OPENING_BRACKETS = "[{(";
    private static final String CLOSING_BRACKETS = "]})";
    private final String input;

    public N3WellFormedBrackets(String input) {
        handleException(input);
        this.input = input;
    }

    private void handleException(String input) {
        if (Objects.isNull(input))
            throw new NullInput();
    }

    public boolean isWellFormed() {
        char[] chars = input.toCharArray();
        Stack<Character> bracketStack = new Stack<>(5000);

        for (char ch : chars) {
            if (isOpeningBracket(ch)) {
                bracketStack.push(ch);
            } else if (isClosingBracket(ch) ||
                    bracketStack.isEmpty() ||
                    !areComplimentaryBrackets(ch, bracketStack.pop())) {
                return false;
            }  //ignore other inputs

        }
        return bracketStack.isEmpty();
    }

    private boolean areComplimentaryBrackets(char ch, Character pop) {
        return OPENING_BRACKETS.indexOf(pop) == CLOSING_BRACKETS.indexOf(ch);
    }

    private boolean isOpeningBracket(char ch) {
        return OPENING_BRACKETS.indexOf(ch) >= 0;
    }

    private boolean isClosingBracket(char ch) {
        return CLOSING_BRACKETS.indexOf(ch) >= 0;
    }

    public static class NullInput extends RuntimeException {
    }

}