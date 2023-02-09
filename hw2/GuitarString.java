import java.util.*;

public class GuitarString {
   
   public static final double DECAY_FACTOR = 0.996;
   private static final int SAMPLE_RATE = 44100; 
   private Queue<Double> ringBuffer = new LinkedList<>();
   
   // pre: If the frequency <= 0 or if N < 2, throw IllegalArgumentException.
   public GuitarString(double frequency) {
      
      int N = (int) Math.round(SAMPLE_RATE / frequency);
      if (frequency <= 0 || N < 2) {
         throw new IllegalArgumentException();
      }
    
      doubleArrayToQueue(new double[N], ringBuffer);   
   }
   
   // pre: If length of init < 2, throw an IllegalArgumentException.
   public GuitarString(double[] init) {
      
      if (init.length < 2) {
         throw new IllegalArgumentException();
      }
      doubleArrayToQueue(init, ringBuffer);
      
   }
   
   private void doubleArrayToQueue(double[] d, Queue<Double> q) {
      for (double nextDouble: d) {
         q.add(nextDouble);
      }
   }
   
   public void pluck() {
      double min = -0.5;
      double max = 0.5;
      Random r = new Random();
      for (int i = 0; i < ringBuffer.size(); i++) {
         double randomDouble = min + (max - min) * r.nextDouble();
         ringBuffer.add(randomDouble);
         ringBuffer.remove();
      }
      
   }
   
   public void tic() {
      
      double first = ringBuffer.remove();
      double second = ringBuffer.peek();
      double toAdd = DECAY_FACTOR * 0.5 * (first + second);
      ringBuffer.add(toAdd);  
   }
   
   public double sample() {
   
      return ringBuffer.peek();
   }

}