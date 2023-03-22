public class RecursionPract {

   public static void main(String[] args) {
      
      // System.out.println(repeat(534));
      // writeStars(3);
      reverse(new String[] { "this", "is", "fun", "no?" });
      
      
   }
   
   //pre: n >= 0
   public static int repeat(int n) {
      if (n < 10) {
         return 11 * n;
      }else {
         return 100 * repeat(n / 10) + repeat(n % 10);
      }
   }
   
   public static void writeStars(int n) {
      if (n == 0) {
         System.out.println();
      }
      else {
         System.out.print("*");
         writeStars(n-1);
      }
   }
   
   public static void reverse(String[] words) {
  
      reverse(words, 0);       
   }
   
   private static void reverse(String[] words, int index) {
   
      if (index != words.length) {
         
         System.out.println(words[-1 * (index - words.length + 1)]);
         reverse(words, index + 1);
      }  
   }

}