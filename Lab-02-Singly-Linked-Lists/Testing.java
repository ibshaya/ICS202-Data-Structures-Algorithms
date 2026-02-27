public class Testing {
    // Task 3
    public static void main(String[] args) {
        SLL<Integer> linkedList = new SLL<>();

        linkedList.addToTail(1);
        linkedList.addToTail(2);
        linkedList.addToTail(4);
        linkedList.addToTail(11);
        linkedList.addToTail(2);
        linkedList.addToTail(9);

        System.out.println("Original array: " + linkedList);

        linkedList.insertBefore(4, 20);
        System.out.println("After inserting 20 before index 4: " + linkedList);

        try{
            int deletedElement = linkedList.delete(4);
            System.out.println("Element deleted from index 4: " + deletedElement);
            System.out.println("After deleting element "+ deletedElement+" from index 4: " + linkedList);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        linkedList.insertAfterSecondOccurrence(30, 2);
        System.out.println("After inserting 30 after the second occurrence of 2: " + linkedList);
    }
}
