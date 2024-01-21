// a doublelinkedlist node
public class Node {
    
    private int item;
    private Node prev;
    private Node next;

    public Node(int item){
        this.item = item;
        this.prev = this.next = null;
    }

    public int getItem() {
        return item;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }
    
    public void setItem(int item) {
        this.item = item;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("%s", this.item);
    }
}
