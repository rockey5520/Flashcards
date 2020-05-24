import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        switch (operator){
            case "MAX":
                max(args);
                break;
            case "MIN":
                min(args);
                break;
            case "SUM":
                sum(args);
                break;
        }
    }

    private static void sum(String[] args) {
        List<String> updatedArgs = Arrays.asList(args).subList(1, args.length);
        List<Integer> integerList = new ArrayList<>();
        for (String x : updatedArgs) {
            integerList.add(Integer.parseInt(x));
        }
        int sum = 0;
        for (Integer integer: integerList
        ) {
            sum+= integer;
        }
        System.out.println(sum);
    }

    private static void min(String[] args) {
        List<String> updatedArgs = Arrays.asList(args).subList(1, args.length);
        List<Integer> integerList = new ArrayList<>();
        for (String x : updatedArgs) {
            integerList.add(Integer.parseInt(x));
        }
        Integer min1 = Collections.min(integerList);
        System.out.println(min1);
    }

    private static void max(String[] args) {
        List<String> updatedArgs = Arrays.asList(args).subList(1, args.length);
        List<Integer> integerList = new ArrayList<>();
        for (String x : updatedArgs) {
            integerList.add(Integer.parseInt(x));
        }
        Integer max1 = Collections.max(integerList);
        System.out.println(max1);
    }
}