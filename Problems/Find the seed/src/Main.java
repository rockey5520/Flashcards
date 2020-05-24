import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Map<Integer, Integer> finalMap = new HashMap<>();
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int n = scanner.nextInt();
    int k = scanner.nextInt();

    for (int i = a; i <= b; i++) {
      Random random = new Random(i);
      Map<Integer, Integer> map = new HashMap<>();
      for (int j = 0; j < n; j++) {
        map.put(j, random.nextInt(k));
      }
      finalMap.put(i, Collections.max(map.values()));
    }

    int maxMinimum = k;
    int seed = b;
    for (var entry : finalMap.entrySet()) {
      int nextMaximum = entry.getValue();
      if (nextMaximum < maxMinimum) {
        maxMinimum = nextMaximum;
        seed = entry.getKey();
      }
    }

    System.out.println(seed);
    System.out.println(maxMinimum);


  }
}