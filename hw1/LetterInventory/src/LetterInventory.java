public class LetterInventory {

  private int size; // total count of all the letters in the inventory
  private int[] charCount; // an integer array representing the number of counts of each alphabet.
  // e.g. the int stored at index 0 of this array is the number of 'a's there are
  // in upper and lower case
  private static final int NUMBER_OF_LETTERS = 26;

  public LetterInventory(String data) {

    charCount = new int[NUMBER_OF_LETTERS];

    // Loop through the string
    for (int i = 0; i < data.length(); i++) {

      char ch = data.charAt(i);
      if (Character.isLetter(ch)) {
        int displacement = checkDisplacement(ch);
        charCount[displacement]++;
        size++;

      }
    }

  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private int checkDisplacement(char ch) {

    return Character.toLowerCase(ch) - 'a';
  }

  // pre : char passed must be alphabetic (throws IllegalArgumentException if not)
  // post: returns a count of how many of this letter are in the inventory.
  public int get(char ch) {

    if (!Character.isLetter(ch)) {
      throw new IllegalArgumentException();
    }

    int displacement = checkDisplacement(ch);
    return charCount[displacement];

  }

  public String toString() {

    if (size == 0) {
      return "[]";
    }

    String result = "[";
    for (int i = 0; i < NUMBER_OF_LETTERS; i++) {
      char ch = (char) ('a' + i);
      int numOfLetters = charCount[i];
      String toAdd = Character.toString(ch).repeat(numOfLetters);
      result += toAdd;

    }
    result += "]";
    return result;

  }
  
  // pre : If a nonalphabetic character is passed or if value is negative, throw an IllegalArgumentException.
  // post: Sets the count for the given letter to the given value.
  public void set(char letter, int value) {
   if (!Character.isLetter(letter) || value < 0) {
      throw new IllegalArgumentException();
   }
   
   int displacement = checkDisplacement(letter);
   int currentCount = charCount[displacement];
   int difference = value - currentCount;
   charCount[displacement] = value;
   size += difference;
  }
  
  public LetterInventory add(LetterInventory other) {
   // Create a new LetterInventory object first
   LetterInventory newLetterInventory = new LetterInventory("");
   int newSize = this.size + other.size;
   // set the newLetterInventory size attribute 
   newLetterInventory.size = newSize;
   int[] newCharCount = new int[NUMBER_OF_LETTERS];
   for (int i = 0; i < NUMBER_OF_LETTERS; i++) {
      newCharCount[i] = charCount[i] + other.charCount[i];
   }
   // set the newLetterInventory charCount attribute
   newLetterInventory.charCount = newCharCount;
   
   return newLetterInventory;
  }
  
  public LetterInventory subtract(LetterInventory other) {
  
   int newSize = this.size - other.size;
   if (newSize < 0) return null;
   int[] newCharCount = new int[NUMBER_OF_LETTERS];
   for (int i = 0; i < NUMBER_OF_LETTERS; i++) {
      newCharCount[i] = charCount[i] - other.charCount[i];
      if (newCharCount[i] < 0) return null;
   }
   
   LetterInventory newLetterInventory = new LetterInventory("");
   // set the newLetterInventory size attribute 
   newLetterInventory.size = newSize;
   // set the newLetterInventory charCount attribute
   newLetterInventory.charCount = newCharCount;
   return newLetterInventory;
  
  }
  
}
