package Soal_01;

// UBAH CODE DI FILE INI AGAR MENGHASILKAN OUTPUT SESUAI INSTRUKSI PADA SOAL

public class soal01 {

   public static void main(String[] args) {

      int[] arr = {1, 9, 10, 3, 2, 5, 4, 7, 6, 8, 11, 13, 12, 14, 15};

      for (int x : arr) {
         String prime = MyLibrary.isPrimeNumber(x);
         String odd = MyLibrary.isOddNumber(x);
         String even = MyLibrary.isEvenNumber(x);
         System.out.println(String.format("n = %2d -> isPrime ? %s, isOdd ? %s, isEven ? %s", x, prime, odd, even));
      }

   }
   
}