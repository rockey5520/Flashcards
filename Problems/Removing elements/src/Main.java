import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        String[] s = str.split("\\s+");
        Set<Integer> integerSet = new TreeSet<>();
        for (String s1:s
        ) {
            integerSet.add(Integer.parseInt(s1));
        }
        return integerSet;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        set.removeIf(x -> x > 10);
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}