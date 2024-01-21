public class DoubleLinkedList {

    Node head;
    Node tail;
    int count;

    public DoubleLinkedList(){
        head = tail = null;
        count = 0;
        //count diatas tergantung dengan datanya jika kosong 0

    }
    public void add (int item) {
        Node node = new Node(item);
        if (count == 0){
            head = tail = node;
        }
        else {
            tail.setNext (node);
            node.setPrev(tail);
            tail=node;
        }
        count++;
}

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    if (count != 0) {
        Node p = head;
        while (p != null) {
            if (sb.length() == 0)
                sb.append(String.format("%s", p.getItem()));
            else
                sb.append(String.format(", %s", p.getItem()));
            p = p.getNext();
        }
    }
    return sb.toString();
}
}