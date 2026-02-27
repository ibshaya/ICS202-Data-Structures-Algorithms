public class Entry<T> {
    private T dataObject;
    private String status;

    public Entry(T dataObject) {
        this.dataObject = dataObject;
        this.status = "E"; // Initialize status as "empty" by default
    }

    public T getDataObject() {
        return dataObject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return dataObject.toString();
    }

    public int hash() {
        return dataObject.hashCode();
    }
}
