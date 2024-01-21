package Soal_04;

// READONLY CODE - JANGAN MENGUBAH CODE APA PUN YANG ADA DI FILE INI

public class soal04 {
   
   public static void main(String[] args) {
   
      int[] arr = {1, 2, 3, 4, 3, 4, 2, 3, 4, 5, 2, 2};

      LinkedList list = new LinkedList();

      for (int x : arr) {
         list.add(x);
      }

      // menampilkan isi list awal
      System.out.println("list awal: " + list);
      System.out.println("count: " + list.getCount());

      int item = 2;

      System.out.println("List memiliki data elemen: 2 ? " + list.contain(item));

      // delete semua elemen: 2
      System.out.println("Delete semua elemen: 2");
      list.removeAll(item);

      // menampilkan isi list akhir
      System.out.println("list akhir: " + list);
      System.out.println("count: " + list.getCount());

   }

}