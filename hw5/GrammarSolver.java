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
   
   }


}