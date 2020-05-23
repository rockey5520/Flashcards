import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        map1 = makeMap(s1, map1);
        map2 = makeMap(s2, map2);
        System.out.println(map1.equals(map2)?"yes":"no");

    }

    private static HashMap<Character, Integer> makeMap(String s1, HashMap<Character, Integer> map1) {
        char[] chars1 = s1.toLowerCase().toCharArray();
        for (char aChar : chars1
        ) {
            if (map1.containsKey(aChar)) {
                map1.put(aChar, map1.get(aChar) + 1);
            } else {
                map1.put(aChar, 1);
            }
        }
        return map1;
    }
}