import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

class Main {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(Paths.get(
        "C:\\Users\\Rockey\\IdeaProjects\\Flashcards\\Problems\\Printing strings in the same order\\src\\dataset_91065.txt"));
    long count = 0;
    while (scanner.hasNext()) {
      long i = scanner.nextInt();
      if (i == 0) {
        break;
      }
      if (i % 2 == 0) {
        count++;
      }
      //sum+= i >= 9999?0:i;
    }
    System.out.println(count);
    File file = new File("file.txt"); // some file

    try (FileWriter writer = new FileWriter(file, true)) {
      writer.write("Lorem ipsum");
    }
    int[] a = new int[]{9, 8, 3, 1, 5, 4};
    for (int i = 0; i < a.length; i++) {

      if (a[i] % 2 == 0) {
        a[i] += 1;
      } else if (a[i] < a.length) {
        a[i] += a[a[i]];
      }
    }

    System.out.println(Arrays.toString(a));

  }

}