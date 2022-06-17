package stack_and_queues;

import stack_and_queues.mathmetical_ops.*;

import java.util.Objects;

public class N2RPN {
    private String rpnPresentation;

    public N2RPN(String rpnPresentation) {
        handleException(rpnPresentation);
        this.rpnPresentation = rpnPresentation;
    }

    private void handleException(String rpnPresentation) {
        if (Objects.isNull(rpnPresentation))
            throw new InvalidInput();
    }

    public int eval() {
        Stack<String> stack = new Stack<>(5000);
        String[] elements = rpnPresentation.split(",");
        int result;
        try {
            for (String element : elements) {
                element = element.toLowerCase().trim();
                if (element.length() == 1 && "+/*-x".indexOf(element) >= 0) {
                    int n1 = Integer.parseInt(stack.pop());
                    int n2 = Integer.parseInt(stack.pop());
                    switch (element) {
                        case "+":
                            performOperation(new AddOperation(), stack, n1, n2);
                            break;
                        case "-":
                            performOperation(new SubtractionOperation(), stack, n1, n2);
                            break;
                        case "*":
                        case "x":
                            performOperation(new MultiplicationOperation(), stack, n1, n2);
                            break;
                        case "/":
                            performOperation(new DivideOperation(), stack, n1, n2);
                            break;
                        default:
                    }
                } else {
                    stack.push(element);
                }
            }
            result = Integer.valueOf(stack.pop());
        } catch (Exception exception) {
            throw new InvalidInput();
        }

        if (!stack.isEmpty())
            throw new InvalidInput();
        return result;
    }

    private void performOperation(MathOperation mathOperation, Stack<String> stack, int n1, int n2) {
        int op = mathOperation.perform(n2, n1);
        stack.push(String.valueOf(op));
    }

    public static class InvalidInput extends RuntimeException {
    }
}
