import java.util.Scanner;

public class Postfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LabStack<Integer> stack = new LabStack<>();
        int stackSize = 0; // Track the size of the stack

        System.out.print("Enter your <postfix> expression: ");
        String expression = scanner.nextLine();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isInteger(token)) {
                stack.push(Integer.parseInt(token));
                stackSize++; // Increment stack size when pushing an element
            } else if (isOperator(token)) {
                if (stackSize < 2) {
                    System.out.println("Your postfix expression is not valid");
                    return;
                }
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = evaluate(token.charAt(0), operand1, operand2);
                stack.push(result);
                stackSize--; // Decrement stack size after popping two elements and pushing one result
            } else {
                System.out.println("Your postfix expression is not valid");
                return;
            }
            System.out.println("Currently, the stack is>> " + stack.toString());
        }

        if (stackSize == 1) { // Check the stack size
            int finalResult = stack.pop();
            System.out.println("Final result: " + finalResult);
        } else {
            System.out.println("Your postfix expression is not valid");
        }

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOperator(String s) {
        return s.length() == 1 && "+-*/".contains(s);
    }

    public static int evaluate(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
