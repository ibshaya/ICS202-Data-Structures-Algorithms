import java.util.*;

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        // Create the binary search tree with the specified keys
        BST<Integer> bst = new BST<>();
        bst.insert(8);
        bst.insert(4);
        bst.insert(9);
        bst.insert(2);
        bst.insert(7);

        // Test methods and print results
        System.out.println("The number of nodes is " + bst.count());
        System.out.println("'4' is leaf? " + bst.isLeaf(4));
        System.out.println("'7' is leaf? " + bst.isLeaf(7));
        System.out.println("Number of Leaves is " + bst.countLeaves());
        System.out.println("Height is " + bst.height());

        System.out.println("The various traversals are>> ");
        // Print the depth-first preorder traversal
        System.out.print("Preorder: ");
        bst.preorder();
        System.out.println();

        // Print the depth-first inorder traversal
        System.out.print("Inorder: ");
        bst.inorder();
        System.out.println();

        // Print the depth-first postorder traversal
        System.out.print("Postorder: ");
        bst.postorder();
        System.out.println();

        // Print the breadth-first traversal
        System.out.print("Breadth First: ");
        bst.breadthFirst();
        System.out.println();
    }
}
