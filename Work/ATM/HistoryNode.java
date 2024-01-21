package ATM;

public class HistoryNode {
    private History history;
    private HistoryNode next;

    public HistoryNode(History history) {
        this.history = history;
        this.next = null;
    }

    public History getHistory() {
        return history;
    }

    public HistoryNode getNext() {
        return next;
    }

    public void setNext(HistoryNode next) {
        this.next = next;
    }
}
