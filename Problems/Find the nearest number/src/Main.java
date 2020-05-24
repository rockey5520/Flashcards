import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> distances = new ArrayList<>();

        String[] line = scanner.nextLine().split(" ");

        for (String element : line) {
            numbers.add(Integer.parseInt(element));
        }

        int number = Integer.parseInt(scanner.nextLine());

        for (int num : numbers) {
            distances.add((int)(Math.pow(num - number, 2)));
        }

        int minDistance = Collections.min(distances);

        distances.clear();

        for (int num : numbers) {
            if (Math.pow(num - number, 2) == minDistance) {
                distances.add(num);
            }
        }

        Collections.sort(distances);

        for (int num : distances) {
            System.out.print(num + " ");
        }

    }
}