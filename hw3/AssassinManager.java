import java.util.*;

public class AssassinManager {
   
   private AssassinNode frontKillRing;
   private AssassinNode frontGraveyard;
   
   
   // pre: names must not be empty. Throw IllegalArgumentException otherwise.
   // post: add names from the list into the killList 
   AssassinManager(List<String> names) {
   
      if (names.size() == 0) {
         throw new IllegalArgumentException();
      }
      
      frontKillRing = null;
      
      for (int i = names.size()-1; i >= 0; i--) {
         
         frontKillRing = new AssassinNode(names.get(i), frontKillRing);
      }
      
   
   }
   
   public void printKillRing() {
      
      AssassinNode current = frontKillRing;
      
      while(current != null) {
      
         AssassinNode next = current.next;
         
         if (next == null) {
         
            System.out.println("    " + current.name + " is stalking " + frontKillRing.name);
         } else {
         
            System.out.println("    " + current.name + " is stalking " + next.name);
         }
         
         current = current.next;
      }
   }
   
   public void printGraveyard() {
      
      if (frontGraveyard == null) System.out.print("");
      
   
   }
   
   public boolean killRingContains(String name) {
   
      // Loop through list
      AssassinNode current = frontKillRing;
      while (current != null) {
      
         if (current.name.toLowerCase() == name.toLowerCase()) return true;
         current = current.next;
      }
      
      return false;
   }
   
   
   public boolean graveyardContains(String name) {
   
      // Loop through list
      AssassinNode current = frontGraveyard;
      while (current != null) {
      
         if (current.name.toLowerCase() == name.toLowerCase()) return true;
         current = current.next;
      }
      
      return false;
   }
   
   
   public boolean gameOver() {
      
      return frontKillRing.next == null;
   }
   
   public String winner() {
   
      if (!gameOver()) return null;
      
      return frontKillRing.name;
   }
   
   // pre: throw an IllegalArgumentException if the given name is not part of the current kill ring
   // pre: throw an IllegalStateException if the game is over  
   public void kill(String name) {
   
      if (!killRingContains(name)) throw new IllegalArgumentException();
      else if (gameOver()) throw new IllegalStateException();
      
      AssassinNode current = frontKillRing;
      AssassinNode personKilled = null;
      AssassinNode killer = null;
      
      while (current.name != name) {
      
         killer = current;
         current = current.next;
      }
      
      personKilled = current;
      
      // this scenario happens if the person killed is the first in the killRing
      if (killer == null) {
      
         while (killer == null) {
            current = current.next;
            if (current.next == null) killer = current;
         }
         
         frontKillRing = personKilled.next;
      }
      
      else killer.next = personKilled.next;
      
      personKilled.killer = killer.name;
      
      // code to move personKilled to graveYard;
   
   }
   
   
   
}