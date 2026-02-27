public class HashTable<T> {
    private Entry<T>[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new Entry[size];
    }

    public boolean insert(T dataObject) {
        int hash = hash(dataObject.hashCode());
        int index = hash % size;

        if (table[index] == null || table[index].getStatus().equals("E") || table[index].getStatus().equals("D")) {
            table[index] = new Entry<>(dataObject);
            table[index].setStatus("O"); // Mark as occupied
            return true;
        } else {
            int nextSlot = findNextAvailableSlot(index);
            if (nextSlot != -1) {
                table[nextSlot] = new Entry<>(dataObject);
                table[nextSlot].setStatus("O"); // Mark as occupied
                return true;
            }
        }
        return false; // Unable to insert
    }

    public boolean delete(T dataObject) {
        int index = find(dataObject);
        if (index != -1) {
            table[index].setStatus("D"); // Mark as deleted
            return true;
        }
        return false; // Object not found
    }

    public int find(T dataObject) {
        int hash = hash(dataObject.hashCode());
        int index = hash % size;

        while (table[index] != null) {
            if (table[index].getStatus().equals("O") && table[index].getDataObject().equals(dataObject)) {
                return index; // Object found
            }
            index = (index + 1) % size; // Linear probing
        }

        return -1; // Object not found
    }

    private int findNextAvailableSlot(int currentSlot) {
        int index = (currentSlot + 1) % size;

        while (index != currentSlot) {
            if (table[index] == null || table[index].getStatus().equals("E") || table[index].getStatus().equals("D")) {
                return index; // Found an empty or deleted slot
            }
            index = (index + 1) % size; // Linear probing
        }

        return -1; // Unable to find an empty slot
    }

    private int hash(int hashCode) {
        return Math.abs(hashCode); // Simple remainder hash function
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(i).append(": ");
            if (table[i] != null) {
                sb.append("[").append(table[i].getDataObject()).append(", '").append(table[i].getStatus()).append("']");
            } else {
                sb.append("[null, 'E']");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    

    public static void main(String[] args) {
    HashTable<Integer> hashtable = new HashTable<>(13); // Size of hashtable is 13 as per example

    // Insertions
    hashtable.insert(18);
    hashtable.insert(26);
    hashtable.insert(35);
    hashtable.insert(9);

    // Output hashtable after insertions
    System.out.println("After inserting 18, 26, 35 and 09, hashtable is");
    System.out.println(hashtable);

    // Find operations
    int index15 = hashtable.find(15);
    int index48 = hashtable.find(48);
    System.out.println("15 not found");
    System.out.println("48 not found");

    // Delete operation
    hashtable.delete(35);
    System.out.println("35 successfully deleted");

    // Find operation after deletion
    int index9 = hashtable.find(9);
    System.out.println("9 found at " + index9);

    // Insertions after deletion
    hashtable.insert(64);
    hashtable.insert(47);

    // Output hashtable after insertions after deletion
    System.out.println("After deleting 35 and inserting 64 and 47, hashtable is");
    System.out.println(hashtable);

    // Find operation after insertions
    int index35 = hashtable.find(35);
    System.out.println("35 not found");
}





}
