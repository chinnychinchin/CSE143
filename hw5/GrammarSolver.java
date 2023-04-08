import java.util.*;

public class GrammarSolver {
   
   private SortedMap<String, String> theGrammarMap;
   
   // pre: if the grammar is empty or if there are two or more entries in the grammar 
   //      for the same nonterminal, throw IllegalArgumentException
   public GrammarSolver(List<String> grammar) {
      
      if(grammar.isEmpty()) {
         throw new IllegalArgumentException();
      }
      
      // instantiate theGrammarMap
      theGrammarMap = new TreeMap<>();
      // loop through list and add the grammar into the map
      for (String s : grammar) {
      
         String[] parts = s.split("::=");
         if (theGrammarMap.containsKey(parts[0])) {
            throw new IllegalArgumentException();
         }
         theGrammarMap.put(parts[0],parts[1]);
      }
   
   }
   
   public boolean grammarContains(String symbol) {
   
      return theGrammarMap.containsKey(symbol);
   }
   
   // pre: throw an IllegalArgumentException if the grammar does not
   //      contain the given nonterminal symbol or if the number
   //      of times is less than 0. 
   public String[] generate(String symbol, int times) {
   
      if (!grammarContains(symbol) ||  times < 0) {
         throw new IllegalArgumentException();
      }
      // replace the return statement below 
      return new String[4];
   }

   public String getSymbols() {
   
      return theGrammarMap.keySet().toString();
   }
}