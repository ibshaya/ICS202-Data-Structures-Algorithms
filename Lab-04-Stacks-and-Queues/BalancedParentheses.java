import java.util.Scanner;

public class BalancedParentheses {
    public static boolean isBalanced(String expression) {
        LabStack<Character> stack = new LabStack<>();

        //Remove all non parentheses characters
        String parenthesesOnly = expression.replaceAll("[^\\[\\](){}]", "");

        for (char c : parenthesesOnly.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false; //More closing parentheses than opening ones
                }
                char opening = stack.pop();
                if ((c == ']' && opening != '[') ||
                        (c == ')' && opening != '(') ||
                        (c == '}' && opening != '{')) {
                    return false; // Mismatched parentheses
                }
            }
        }

        //If the stack is empty at the end the expression is balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your expression: ");
            String expression = scanner.nextLine();
            scanner.close();

            if (isBalanced(expression)) {
                System.out.println("The expression is balanced");
            } else {
                System.out.println("The expression is not balanced");
            }


    }
}

