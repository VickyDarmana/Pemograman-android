package Soal_03;

// READONLY - JANGAN MENGUBAH CODE YANG ADA PADA FILE INI

public class soal03 {
   public static void main(String[] args) {
      
      int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};

      ArrayList arrList = new ArrayList();

      for (int x : arr) {
         arrList.add(x);
      }

      // menampilkan data awal
      System.out.println("\ndata awal: " + arrList);

      // swap elemen pada index 4 dan 5
      
      int index1 = 4, index2 = 5;
      
      System.out.println("\nSwap data pada index: " + index1 + " = " + arrList.get(index1) + " dengan data pada index: " + index2 + " = " + arrList.get(index2) + "\n");

      arrList.swap(index1, index2);

      // menampilkan data setelah proses swap-ing
      System.out.println("data akhir: " + arrList + "\n");


   }
}