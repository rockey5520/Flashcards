import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

class Main {

  public static void main(String[] args) throws IOException {
    ArrayList<Character> characters = new ArrayList<>();

    characters.add('a');
    characters.add('b');
    characters.add(1, 'c');
    characters.add(1, 'd');
    characters.add('e');
    characters.add(5, 'f');
    System.out.println(characters.toString());
  }

}