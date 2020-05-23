import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        List<String> strings = new ArrayList<>();
        while (!(line = scanner.nextLine()).equals("0")){
            strings.add(line);
        }

        for (String s: strings
        ) {
            try{
                System.out.println(Integer.parseInt(s)*10);
            }catch (NumberFormatException e){
                System.out.println( "Invalid user input: "+s);
            }
        }



    }
}