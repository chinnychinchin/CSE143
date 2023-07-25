import java.util.*;

public class AnagramSolver {
   
   private Map<String, LetterInventory> dictMap;
   private Stack<String> solution;
   private final List<String> list;
   
   public AnagramSolver(List<String> list) {
      
      dictMap = new HashMap<>();
      solution = new Stack<>();
      this.list = list;
      
      for (String word : list) {
         dictMap.put(word, new LetterInventory(word));
      }
      
   }
   
   public void print(String s, int max) {
   
      if (max < 0) {
         throw new IllegalArgumentException();
      }
      
      else if (max == 0) {
         print(new LetterInventory(s), dictMap.size());
      }
      
      else {
         print(new LetterInventory(s), max);
      }
      
   }
   
   
   private void print(LetterInventory currInventory, int max) {
   
      if (currInventory.isEmpty()) {
      
         System.out.println(solution);
      }
      
      else {
         
         for (String key : list) {
          
            LetterInventory newInventory = currInventory.subtract(dictMap.get(key));
            if (newInventory != null && max > 0) {
               solution.push(key);
               print(newInventory, max - 1);
               // Code to 'unchoose'
               solution.pop();
            }
         }
      }
   }



}