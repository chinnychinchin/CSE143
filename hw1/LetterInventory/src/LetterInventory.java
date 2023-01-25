public class LetterInventory {

    private int size; // total count of all the letters in the inventory
    private int[] charCount; // an integer array representing the number of counts of each alphabet.
    // e.g. the int stored at index 0 of this array is the number of 'a's there are in upper and lower case
    private static final int NUMBER_OF_LETTERS = 26;

    public LetterInventory (String data) {

        charCount = new int[NUMBER_OF_LETTERS];

        // Loop through the string
        for (int i = 0; i < data.length(); i++) {

            char ch = data.charAt(i);
            if (Character.isLetter(ch)) {
                int displacement = Character.toLowerCase(ch) - 'a';
                charCount[displacement]++;
                size++;

            }
        }

    }
}
