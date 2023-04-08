import java.util.*;

public class GrammarSolver {
   
   private SortedMap<String, String> theGrammarMap;
   private Random randomObj;
   
   // pre: if the grammar is empty or if there are two or more entries in the grammar 
   //      for the same nonterminal, throw IllegalArgumentException
   public GrammarSolver(List<String> grammar) {
      
      if(grammar.isEmpty()) {
         throw new IllegalArgumentException();
      }
      
      // instantiate randomOjb
      randomObj = new Random(); 
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
   
      if (!grammarContains(symbol) || times < 0) {
         throw new IllegalArgumentException();
      }
      
      return generatePri(symbol, times);
      
      
   }
   
   // For each time, select a random rule
   // check if rule is terminal
   // if it is, add a random terminal to the String[] to be returned   
   
   private String[] generatePri(String symbol, int times) {
   
      String[] arrayToReturn = new String[times];
      String[] rules = theGrammarMap.get(symbol).split("[|]"); 
      for (int i = 0; i < times; i++) {
      
         String randomRule = rules[randomObj.nextInt(rules.length)];
         // if block is for the case when rule is a terminal. This is the base case 
         if (!grammarContains(randomRule)) {
         
            arrayToReturn[i] = rules[randomObj.nextInt(rules.length)];
         }
         else {
         
            arrayToReturn = generatePri(randomRule, 1);
         }    
      
      }
    return arrayToReturn;

   }
   
 

   public String getSymbols() {
   
      return theGrammarMap.keySet().toString();
   }
   
   
   
}