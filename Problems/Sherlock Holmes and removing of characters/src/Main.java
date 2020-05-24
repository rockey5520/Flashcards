import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class Main {

  public static void main(String[] args) {
    Random generator = new Random();
    int a = generator.nextInt(3);
    int b = generator.nextInt(2) + 1;
    int c = generator.nextInt(4);
    System.out.println(b);
    System.out.println(a + " " + b + " " + c);

    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    String s2 = scanner.nextLine();
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();
    makeMap(s1, map1);
    makeMap(s2, map2);
    int count = 0;

    Set<Character> characters = new HashSet<>();
    characters.addAll(map1.keySet());
    characters.addAll(map2.keySet());

    for (Character character : characters
    ) {
      Integer v1 = map1.getOrDefault(character, 0);
      Integer v2 = map2.getOrDefault(character, 0);
      if (v1 != v2) {
        count += Math.abs(v1 - v2);
      }

    }

    System.out.println(count);

  }

  private static void makeMap(String s1, HashMap<Character, Integer> map1) {
    char[] chars1 = s1.toLowerCase().toCharArray();
    for (char aChar : chars1
    ) {
      if (map1.containsKey(aChar)) {
        map1.put(aChar, map1.get(aChar) + 1);
      } else {
        map1.put(aChar, 1);
      }
    }
  }
}