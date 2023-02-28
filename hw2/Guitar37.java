public class Guitar37 implements Guitar {
    public static final String KEYBOARD =
       "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout

    private GuitarString[] strings;
    private int numOfTimesTicCalled;

    public Guitar37() {

        numOfTimesTicCalled = 0;
        strings = new GuitarString[KEYBOARD.length()];
        // initialise strings array
        for (int i = 0; i < KEYBOARD.length(); i++) {
            strings[i] = new GuitarString(440 * Math.pow(2, (i - 24)/12.0));
        }
    }

    public void playNote(int pitch) {

        int index = pitch + 24;
        if (index >= 0 && index < KEYBOARD.length()) {
            strings[index].pluck();
        }
    }

    // pre: character is one of the 37 characters in KEYBOARD. Throw an IllegalArgumentException if not
    // post: pluck the string
    public void pluck(char string) {

        if (!hasString(string)) {
            throw new IllegalArgumentException();
        }
        strings[KEYBOARD.indexOf(string)].pluck();

    }

    public boolean hasString(char string) {

        int index = KEYBOARD.indexOf(Character.toLowerCase(string));
        return !(index == -1);
    }

    public double sample() {
        double sample = 0;

        for (GuitarString s: strings) {
            sample += s.sample();
        }
        return sample;
    }
    public void tic() {

        for (GuitarString s: strings) {
            s.tic();
        }
        numOfTimesTicCalled++;
    }
    public int time() {
    
        return numOfTimesTicCalled;
    }
 
 }