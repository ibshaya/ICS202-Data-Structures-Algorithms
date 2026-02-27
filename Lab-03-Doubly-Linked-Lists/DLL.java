//****************************  DLL.java  *******************************
//                  generic doubly linked list class

public class DLL<T> {
    private DLLNode<T> head, tail;
    public DLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void setToNull() {
        head = tail = null;
    }
    public T firstEl() {
        if (head != null)
             return head.info;
        else return null;
    }
    public void addToHead(T el) {
        if (head != null) {
             head = new DLLNode<T>(el,head,null);
             head.next.prev = head;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public void addToTail(T el) {
        if (tail != null) {
             tail = new DLLNode<T>(el,null,tail);
             tail.prev.next = tail;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public T deleteFromHead() {
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             head = head.next;
             head.prev = null;
        }
        return el;
    }
    public T deleteFromTail() {
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             tail = tail.prev;
             tail.next = null;
        }
        return el;
    }
    public void printAll() { 
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
             System.out.print(tmp.info + " ");
        System.out.println();
    }
    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null)
             return null;
        else return tmp.info;
    }

    //Declaring the printReverse
    public void printReverse (){
        //adding  some text to clearfy that thsi is reverse list
        System.out.print("The reverse list: ");
        //using for loop to travers from the tail to the head
        for (DLLNode<T> tmp = tail; tmp != null; tmp = tmp.prev)
            System.out.print(tmp.info + " ");
        System.out.println();
    }
    public int size() {
        int count = 0;
        DLLNode<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }



    public void insertAlternate(DLL<T> newList) {
        // Check if the lengths of the lists are the same
        if (newList == null || size() != newList.size()) {
            System.out.println("Lists are not the same length.");
            return;
        }
        // Start from the heads of both lists
        DLLNode<T> currentThis = head;
        DLLNode<T> currentNew = newList.head;

        // Insert elements alternately until one of the lists ends
        while (currentThis != null && currentNew != null) {
            // Insert element from newList into the invoking list
            DLLNode<T> nextThis = currentThis.next;
            DLLNode<T> nextNew = currentNew.next;

            // Update pointers to insert currentNew node into currentThis nodes position
            currentThis.next = currentNew;
            currentNew.prev = currentThis;
            currentNew.next = nextThis;

            // Move to the next nodes in both lists
            currentThis = nextThis;
            currentNew = nextNew;
        }
    }


    public void delete7() {
        if (isEmpty()) {
            // If the list is empty no deletion needed
            return;
        }


        DLLNode<T> current = head;
        int count = 1;
        boolean reverse = false; // Flag to indicate if counting direction is reversed

        // Traverse the list until the 7th element from the head or tail
        while (current != null) {



            if (!reverse) {


                // If the 7th element is found and counting direction is not reversed then delete it
                if (current == head) {
                    head = head.next;
                    return;


                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                return; // Exit the method after deletion
            } else if (count == 7 && reverse) {
                // If the 7th element is found and counting direction is reversed then reset count and continue
                count = 0;

            }

            // Move to the next node
            if (!reverse) {
                current = current.next;
            } else {
                current = current.prev;
            }
            count++;

            // If we reach the end of the list then reverse the direction of counting
            if (current == null) {
                current = tail;
                reverse = true;

            }

        }
    }










}