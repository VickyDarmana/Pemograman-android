package ATM;

public class RekeningNode {
    private Rekening rekening;
    private RekeningNode next;

    public RekeningNode(Rekening rekening) {
        this.rekening = rekening;
        this.next = null;
    }

    public Rekening getRekening() {
        return rekening;
    }

    public RekeningNode getNext() {
        return next;
    }

    public void setNext(RekeningNode next) {
        this.next = next;
    }
}
