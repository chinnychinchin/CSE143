import java.util.*;

public class HangmanManager2 extends HangmanManager {
   
   private Set<String> unmodifiableWords;
   private Set<Character> unmodifiableGuesses;
   
   public HangmanManager2 (Collection<String> dictionary, int length, int max) {
   
      super(dictionary, length, max);
      unmodifiableWords = Collections.unmodifiableSet(words);
      unmodifiableGuesses = Collections.unmodifiableSet(guesses);
   }
   
   public Set<String> words() {
      return unmodifiableWords;
   }
   
   public Set<Character> guesses() {
      return unmodifiableGuesses;
   }


}