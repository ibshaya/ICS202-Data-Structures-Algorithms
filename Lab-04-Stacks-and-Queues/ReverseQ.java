import java.util.Scanner;

public class ReverseQ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LabStack<Integer> stack = new LabStack<>();

        //Prompt the user to enter input
        System.out.print("Enter your input> ");
        String input = scanner.nextLine();
        String[] elements = input.split(" ");

        //Push elements onto the stack
        for (String element : elements) {
            if (!element.isEmpty()) {
                stack.push(Integer.parseInt(element));
            }
        }

        //Display the original stack
        System.out.println("Now the stack is>> " + stack.toString());

        //Reverse the stack
        reverseStack(stack);
        //Display the reversed stack
        System.out.println("After Reverse the stack is>> " + stack.toString());

        scanner.close();
    }
    //Method to reverse the order of elements in the stack
    public static void reverseStack(LabStack<Integer> stack) {
        LabQueue<Integer> queue = new LabQueue<>();

        //Dequeue elements from the stack and enqueue them into the queue
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        //Dequeue elements from the queue and push them back onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
    }
}

