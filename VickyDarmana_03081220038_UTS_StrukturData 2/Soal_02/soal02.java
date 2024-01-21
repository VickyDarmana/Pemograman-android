package Soal_02;
public class soal02 {
	public static String isPrimeNumber(int number) {
	      int counter = 0;
	      for (int x = number ; x > 1; x--) {
	    	  if (number%x==0) {
	    		  counter += 1;
	    	  }
	      }
	      if (counter == 1 ) {
	    	  return "Bilangan prima";
	      }
	      return "Bukan bilangan prima";
	   }
	public static void main(String[] args) {
		int[]arr1 = {1,3,5,7,9,11,13,15,17,19,21};
		int[]arr2 = new int [arr1.length];
		for (int x = 0; x<arr1.length; x++) {
			arr2[x] = arr1[x] * arr1[x];
		}
		System.out.printf("array-1:\t\t\t\t\t\t array-2:\n");
		for(int x=0;x<arr1.length;x++) {
			String prime1 = isPrimeNumber(arr1[x]);
			String prime2 = isPrimeNumber(arr2[x]);
			System.out.printf("%d\t= %s \t\t\t\t %d\t = %s\n", arr1[x], prime1, arr2[x], prime2);
		}
	}
}
