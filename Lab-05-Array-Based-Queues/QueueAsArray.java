package Lab05_Recursion.Task02;

// Java program to implement a queue using an array
public class QueueAsArray<T> { 
    private int front, rear, capacity; 
    private T[] queue; 
  
    public QueueAsArray(int capacity) { 
        front = rear = -1; 
        this.capacity = capacity; 
        queue = (T[]) new Object[capacity]; 
    } 
    
    public boolean isEmpty(){
       return front == -1;
    }
    
    public boolean isFull(){
      return rear == capacity - 1;
    }
  
    // function to insert an element at the rear of the queue 
    public void enqueue(T data)  { 
        if (isFull())
            throw new UnsupportedOperationException("Queue is full!"); 
        if(isEmpty())
           front++;
           
           rear++; 
           queue[rear] = data; 
    } 
  
    /*public T dequeue() {
        if (isEmpty()) 
            throw new UnsupportedOperationException("Queue is empty!"); 
        T temp = queue[front];    
        if (rear == 0) {  
            rear = front = -1;
        }
        else{
            for(int i = 0; i <= rear - 1; i++) { 
                queue[i] = queue[i + 1]; 
            } 
            rear--;  
        }
        return temp; 
    }*/

    public T dequeue() {
        if (isEmpty())
            throw new UnsupportedOperationException("Queue is empty!");

        T temp = queue[front]; // Store the front element

        // Base case: if there's only one element
        if (front == rear) {
            front = rear = -1; // Reset front and rear
        } else {
            // Recursive call to shift elements and update rear
            shiftElements(0);
            rear--;
        }

        return temp; // Return the dequeued element
    }

    // Helper method to recursively shift elements in the array
    private void shiftElements(int index) {
        if (index == rear) {
            queue[index] = null; // Set the last element to null
            return;
        }

        queue[index] = queue[index + 1]; // Shift the element
        shiftElements(index + 1); // Recursive call for the next index
    }
       
    public boolean search(T e){
        if (isEmpty()) 
            throw new UnsupportedOperationException("Queue is empty!"); 
            
        for(int i = 0; i <= rear; i++) 
            if(e.equals(queue[i]))
               return true;
               
        return false;
  }
  
  public String toString()  { 
        if (isEmpty()) 
            throw new UnsupportedOperationException("Queue is empty!"); 
         
        String str = "";  
        for (int i = 0; i <= rear; i++) { 
            str = str + queue[i] + "   "; 
        } 
        
        return str;
    } 
  
    public  T peek() { 
        if (isEmpty())
             throw new UnsupportedOperationException("Queue is empty!"); 
 
        return queue[front];  
    } 
} 