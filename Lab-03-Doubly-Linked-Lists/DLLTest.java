import java.util.Random;

public class DLLTest {
	public static void main(String[] args) {
		DLL<String> test = new DLL<String>();
		for(int i = 0; i < 5; i++)
			test.addToTail("a" + i);
		test.printAll();
		test.printReverse();

		DLL<Integer> list1 = new DLL<Integer>();
		list1.addToTail(1);
		list1.addToTail(2);
		list1.addToTail(3);
		list1.addToTail(4);

		DLL<Integer> list2 = new DLL<Integer>();
		list2.addToTail(5);
		list2.addToTail(6);
		list2.addToTail(7);
		list2.addToTail(8);

		list1.insertAlternate(list2);
		System.out.print("List1: " );
		list1.printAll();
		System.out.print("List2: ");
		list2.printAll();
		System.out.println("After testing insert method");
		list1.printAll(); // Output: 1 5 2 6 3 7 4 8


		DLL<Integer> newTest = new DLL<Integer>();

		// Populate the list with random integers
		Random rand = new Random();
		for (int i = 0; i < 10; i++)
			newTest.addToTail(rand.nextInt(100)); // Random integers between 0 and 99

		// Print the initial contents of the list
		newTest.printAll();

		// Delete the 7th element from the list until the list becomes empty
		while (!newTest.isEmpty()) {
			newTest.delete7(); // Delete the 7th element
			newTest.printAll(); // Print the updated list

		}
		newTest.printAll();







	}
}