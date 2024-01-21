package Soal_04;

public class Node {
   
   private int item;
   private Node next;

   public Node(int item) {
      this.item = item;
      this.next = null;
   }

   public int getItem() {
      return item;
   }

   public Node getNext() {
      return next;
   }

   public void setItem(int item) {
      this.item = item;
   }

   public void setNext(Node next) {
      this.next = next;
   }

   @Override
   public String toString() {
      return String.format("%d", item);
   }

}