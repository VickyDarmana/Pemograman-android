package Soal_03;

public class ArrayList {

   private int[] arr;
   private int count;
   private int capacity = 50;

   public ArrayList() {
      arr = new int[capacity];
      count = 0;
   }

   public void add(int item) {
      arr[count++] = item;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      if (count != 0) {
         for (int i = 0; i < count; i++) {
            if (sb.length() == 0)
               sb.append(arr[i]);
            else
               sb.append(String.format(", %d", arr[i]));
         }
      }
      return sb.toString();
   }

   public int get(int index) {
      return arr[index];
   }

   public boolean isValidIndex(int index) {
      return index >= 0 && index < count;
   }

   // method swap ini adalah method yang digunakan untuk melakukan swapping elemen pada idx1 dengan elemen pada idx2
   // pastikan idx1 dan idx2 adalah index yang valid
   // jika idx1 atau idx2 tidak valid, outputkan pesan error: "error: index swapping tidak valid"
   public void swap(int idx1, int idx2) {
      // write your code here
      if(idx1 > arr.length | idx2 > arr. length){
        System.out.println("error : index swapping tidak valid");
      }
      int temp = arr[idx2];
      arr[idx2] = arr[idx1];
      arr[idx1] = temp;
   }

}