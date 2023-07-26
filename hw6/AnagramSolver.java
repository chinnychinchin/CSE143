import java.util.*;

public class AnagramSolver {
   
   private Map<String, LetterInventory> dictMap;
   private Stack<String> solution;
   private final List<String> list;
   private List<String> filteredDictList;
   
   public AnagramSolver(List<String> list) {
      
      dictMap = new HashMap<>();
      solution = new Stack<>();
      this.list = list;    
   }
   
   // pre: max >= 0. Throws IllegalArgumentException if otherwise
   // post: print to System.out all combinations of words from the dictionary that are anagrams of s 
   //       and that include at most max words (or unlimited number of words if max is 0)
   public void print(String s, int max) {
   
      if (max < 0) {
         throw new IllegalArgumentException();
      }
      
      LetterInventory phraseLI = new LetterInventory(s);
      // Code to filter words
      filter(phraseLI);
      
      if (max == 0) {
         print(phraseLI, dictMap.size());
      }
      
      else {
         print(phraseLI, max);
      }
      
   }
   
   private void filter(LetterInventory li) {
      
      filteredDictList = new ArrayList<>();
      
      
      for (String word : list) {
         
         LetterInventory wordLI = new LetterInventory(word);
         
         if (li.subtract(wordLI) != null) {
            
            filteredDictList.add(word);
            dictMap.put(word, wordLI);
         }
         
      }

   }
   
   
   private void print(LetterInventory currInventory, int max) {
   
      if (currInventory.isEmpty()) {
      
         System.out.println(solution);
      }
      
      else {
         
         for (String key : filteredDictList) {
          
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