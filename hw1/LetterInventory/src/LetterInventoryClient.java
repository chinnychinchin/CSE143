public class LetterInventoryClient {

     public static void main(String[] args) {

          LetterInventory li = new LetterInventory("+++bb123");
          System.out.println("size = " + li.size());
          System.out.println("isEmpty = " + li.isEmpty());
          System.out.println(li.get('a'));

          li.set('a', 2);
          System.out.println("li = " + li);
          li.set('c', 3);
          System.out.println("li = " + li);
          li.set('b', 0);
          System.out.println("li = " + li);
          System.out.println("size = " + li.size());
          LetterInventory li2 = new LetterInventory("+++bz123");
          LetterInventory li3 = li.add(li2);
          System.out.println("li3 = " + li3);

     }

}