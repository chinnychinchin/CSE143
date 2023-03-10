import java.util.*;

public class HangmanManager {
   
   private Set<String> words;
   private int guessesLeft;
   private Set<Character> guesses;
   
   //pre: if length < 1 or max < 0, throw IllegalArgumentException
   //post: instantiate an instance of the HangmanManager class
   public HangmanManager(Collection<String> dictionary, int length, int max) {
      
      guessesLeft = max;
      
      words = new TreeSet<>();
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


}