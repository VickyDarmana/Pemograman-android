package Soal_01;

public class MyLibrary {

   public static String isPrimeNumber(int number) {
    if (number <= 1){
        return "Tidak";
    }

    for (int i = 2; i <= Math.sqrt(number); i++){
        if (number % i == 0){
        return "Tidak";
        }
    }
    return "Ya";
   }
   public static String isOddNumber(int number) {

      return number % 2 != 0 ? "Ya" : "Tidak";
   }

   public static String isEvenNumber(int number) {

      return number % 2 == 0 ? "Ya" : "Tidak";
   }

}