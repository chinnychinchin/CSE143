import java.util.*;

public class HangmanManager {
   
   private Set<String> words;
   private int guessesLeft;
   private Set<Character> guesses;
   private String currentPattern;
   private int length;
   
   //pre: if length < 1 or max < 0, throw IllegalArgumentException
   //post: instantiate an instance of the HangmanManager class
   public HangmanManager(Collection<String> dictionary, int length, int max) {
      
      if (length < 1 || max < 0) throw new IllegalArgumentException();
      
      // initialize fields
      guessesLeft = max;
      guesses = new TreeSet<>(); 
      words = new TreeSet<>();
      this.length = length;
      
      // Loop through the dictionary, adding words to the words set
      for (String word: dictionary) { 
         
         if (word.length() == length) words.add(word);
      }
      
   }
   
   public Set<String> words() {
      return words;
   }
   
   public int guessesLeft() {
      return guessesLeft;
   }
   
   public Set<Character> guesses() {
      return guesses;
   }
   
   //pre: throw an IllegalStateException if the set of words is empty
   public String pattern() {
     
      if (words.size() == 0) throw new IllegalStateException();
      
     
      if (guesses.size() == 0) {
      
         String pattern = "-";
         for (int i = 1; i < length; i++) {
            
            pattern += " -";   
         }
         
         currentPattern = pattern;
      }
      
      // to implement logic if there are more guesses
      return currentPattern;
      
   }
   
   /*pre: throw IllegalStateException if the number of guesses left is not at least 1 
          or if the set of words is empty. If previous exception is not thrown, and
          and the character being guessed was guessed previously, 
          throw IllegalArgumentException.
   */
   public int record(char guess) {
      
      if (guessesLeft < 1 || words.size() == 0) throw new IllegalStateException();
      if (guesses.contains(guess)) throw new IllegalArgumentException();
      
      //add guess to guesses set
      guesses.add(guess);
      
      // initialize map
      Map<String, Set<String>> theMap = new TreeMap<>(); 
        
      //iterate over the current set of words
      for (String word: words) {
         
         //determine pattern and add to the map
         String pattern = detPattern(word);
         if (!theMap.containsKey(pattern)) {
         
            theMap.put(pattern, new TreeSet<String>());     
         }
         
         theMap.get(pattern).add(word);
      }
      
      
      // determine correctness of guess by pattern returned by 
      // getPatternWMostWords method and current pattern
      String newPattern = getPatternWMostWords(theMap);
      words = theMap.get(newPattern);
      
      if (currentPattern.equals(newPattern)) {
         // wrong guess. Minus one from guessLeft
         guessesLeft--;
         return 0;
         
      } else {
         // correct guess. Update words field and currentPattern
         currentPattern = newPattern;
         // count the number of occurrences of the guessed letter in the new pattern
         int count = 0;
         for (int i = 0; i < currentPattern.length(); i++) {
            if (currentPattern.charAt(i) == guess) count++;
         }
         return count;
      }
        
   }
   
   // pre: this method assumes that all values in the map have at least 1 word 
   // post: this method finds and returns the pattern with the most words
   private String getPatternWMostWords (Map<String, Set<String>> theMap) {
      
      int numberOfWords = 0;
      String pattern = "";
      // Loop through the map
      for (Map.Entry<String,Set<String>> entry : theMap.entrySet()) {
         
         int n = entry.getValue().size();
         
         if (n > numberOfWords) {
            
            numberOfWords = n;
            pattern = entry.getKey();
         }
      }
      
      return pattern;
   }
   
   private String detPattern(String word) {
      
      String pattern = "";
      char c = word.charAt(0);
      if (guesses.contains(c)) pattern += c;
      else pattern += "-";
    
      // Loop through each char in string
      for (int i = 1; i < word.length(); i++) {
      
         c = word.charAt(i);
         if (guesses.contains(c)) pattern += " " + c;
         else pattern += " " + "-";
      }
      
      return pattern;
   
   }
   

}