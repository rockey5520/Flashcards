import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            char[] chars = line.toCharArray();
            for (int i = chars.length-1; i >= 0 ; i--) {
                System.out.print(chars[i]);
            }
        }
    }
}