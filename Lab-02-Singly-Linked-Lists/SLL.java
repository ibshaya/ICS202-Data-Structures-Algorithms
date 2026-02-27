//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class SLL<T> {

    private class SLLNode<T> {
      private T info;
      private SLLNode<T> next;
      public SLLNode() {
         this(null,null);
      }
      public SLLNode(T el) {
        this(el,null);
      }
      public SLLNode(T el, SLLNode<T> ptr) {
         info = el; next = ptr;
      }
    }

    protected SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info; 
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
             head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
             head = tail = null;
        else {                  // if more than one node in the list,
             SLLNode<T> tmp;    // find the predecessor of tail;
             for (tmp = head; tmp.next != tail; tmp = tmp.next);
             tail = tmp;        // the predecessor of tail becomes tail;
             tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                 head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                 head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                 SLLNode<T> pred, tmp;// and el is in a nonhead node;
                 for (pred = head, tmp = head.next;  
                      tmp != null && !tmp.info.equals(el); 
                      pred = pred.next, tmp = tmp.next);
                 if (tmp != null) {   // if el was found;
                     pred.next = tmp.next;
                     if (tmp == tail) // if el is in the last node;
                        tail = pred;
                 }
            }
    }
    
    @Override
    public String toString() {
       if(head == null)
          return "[ ]";
       String str = "[ ";   
       SLLNode<T> tmp = head;
       while(tmp != null){
         str += tmp.info + " ";
         tmp = tmp.next;
       }
       return str+"]";             
    }
    
    public boolean contains(T el) {
        if(head == null)
            return false;
        SLLNode<T> tmp = head;
        while(tmp != null){
           if(tmp.info.equals(el))
              return true;
           tmp = tmp.next;
        }
        return false;
    }
    
    public int size(){
        if(head == null)
          return 0;
          
        int count = 0;
        SLLNode<T> p = head;
        while(p != null) {
           count++;
           p = p.next;
        }
           
        return count;
    }
    
    //  Please write the methods of Task02 here:
    public void insertBefore(int index, T newElem) {
        try {
            if (isEmpty() || !(index < size() && index >= 0)) {
                throw new Exception();
            } else {
                SLLNode<T> newNode = new SLLNode<>(newElem);
                if (index == 0) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    SLLNode<T> pred = head;
                    for (int i = 0; i < index - 2; i++) {
                        pred = pred.next;
                    }
                    newNode.next = pred.next;
                    pred.next = newNode;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




    public T delete(int index) {
        try {
            if (isEmpty() || !(index < size() && index >= 0))
                throw new Exception();
            else {
                T deletedElem;
                if (index == 0) {
                    deletedElem = head.info;
                    head = head.next;
                    if (head == null) {
                        tail = null;
                    }
                }
                else {
                    SLLNode<T> pred = head;
                    for (int i = 0; i < index - 2; i++) {
                        pred = pred.next;
                    }
                    deletedElem = pred.next.info;
                    pred.next = pred.next.next;
                    if (pred.next == null) {
                        tail = pred;
                    }
                }
                return deletedElem;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null ;
        }
    }
    public void insertAfterSecondOccurrence(T e1, T e2) {
        try {
            if (isEmpty()) {
                throw new Exception();
            }
            SLLNode<T> current = head;
            int firstOccurrenceIndex = -1;
            int count = 0;
            while (current != null) {
                if (current.info != null && current.info.equals(e2)) {
                    if (firstOccurrenceIndex == -1) {
                        firstOccurrenceIndex = count;
                    } else {
                        SLLNode<T> newNode = new SLLNode<>(e1);
                        newNode.next = current.next;
                        current.next = newNode;
                        return;
                    }
                }
                current = current.next;
                count++;
            }
            throw new Exception("No second occurrence of " + e2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




}