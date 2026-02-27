import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestAVL {
	public static void main(String[] args) {
			//Example which works with Left Rotation
         AVLTree<String> t = new AVLTree<String>();
         for(int i = 1; i <= 5; i++)
				t.insertAVL("a" + i);
			t.breadthFirst();
			System.out.println();
		
         System.out.println("Exercise 2");
         
         AVLTree<Integer> Tree = new AVLTree<Integer>();
        // Inserting elements into the AVL tree
        int[] values = {8, 14, 12, 18, 23, 20, 15, 13, 7, 16};
        for (int value : values) {
            Tree.insertAVL(value);
        }

        // Print the original AVL tree in BFS
        System.out.println("Original AVL Tree (BFS):");
        Tree.breadthFirst();
        System.out.println();

        // Prompt the user to provide three elements to delete
        Scanner canner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter element to delete: ");
            int elementToDelete = canner.nextInt();
            Tree.deleteAVL(elementToDelete);
        }
        canner.close();

        // Print the modified AVL tree in BFS after deletion
        System.out.println("\nModified AVL Tree (BFS) after deletion:");
        Tree.breadthFirst();
        System.out.println();


         System.out.println("Exercise 3");
         //read the text file, insert unique words into the AVL tree and print its inorder traversal
         AVLTree<String> avlTree = new AVLTree<String>();

         try {
             // Read the text file
             File file = new File("Lab07\\sampletextfile.txt");
             Scanner scanner = new Scanner(file);
 
             // Process each word in the text file
             while (scanner.hasNext()) {
                 String word = scanner.next().toLowerCase(); // Convert to lowercase to ignore case sensitivity
                 // Check if the word already exists in the AVL tree
                 if (avlTree.search(word) != null) { // If the word already exists
                     System.out.println("The word '" + word + "' already exists in the AVL tree.");
                 } else { // If the word doesn't exist
                     // Insert the word into the AVL tree
                     avlTree.insertAVL(word);
                 }
             }
             scanner.close();
 
             // Print the AVL tree using inorder traversal
             System.out.println("AVL Tree Inorder Traversal:");
             avlTree.inorder();
         } catch (FileNotFoundException e) {
             System.out.println("File not found.");
         }
   }
}