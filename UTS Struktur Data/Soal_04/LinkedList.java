package Soal_04;

public class LinkedList {
   
   private Node head;
   private Node tail;
   private int count;

   public LinkedList() {
      head = tail = null;
      count = 0;
   }

   public Node getHead() {
      return head;
   }

   public Node getTail() {
      return tail;
   }

   public int getCount() {
      return count;
   }

   public void add(int item) {
      Node node = new Node(item);
      if (head == null) {
         head = tail = node;
      }
      else {
         tail.setNext(node);
         tail = node;
      }
      count++;
   }

   public boolean contain(int item) {
      if (count > 0) {
         Node p = getHead();
         while (p != null) {
            if (p.getItem() == item) return true;
            p = p.getNext();
         }
      }
      return false;
   }

   public int getIndex(int item) {
      if (count > 0) {
         Node p = getHead();
         int idx = 0;
         while (p != null) {
            if (p.getItem() == item) return idx;
            p = p.getNext();
            idx++;
         }
      }
      return -1;
   }

   // method ini akan menghapus semua elemen item yang ditemukan di dalam list
   public void removeAll(int item) {
      // write your code here
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      if (count != 0) {
         Node p = getHead();
         while (p != null) {
            if (sb.length() == 0)
               sb.append(p.getItem());
            else 
               sb.append(String.format(", %d", p.getItem()));
            p = p.getNext();
         }   
      }
      return sb.toString();
   }

}