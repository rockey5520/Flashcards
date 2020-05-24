package flashcards;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> stack = new HashMap<String, String>();
        String name = "";
        String def = "";
        ArrayList<String> order = new ArrayList<String>();
        int index = 0;
        boolean stop = false;
        String file;
        int add;

        while (!stop) {
            System.out.println("Input the action (add, remove, import, export, ask, exit):");
            String act = sc.nextLine();
            switch (act) {
                case "add":
                    String[][] card = new String[stack.size()][2];
                    System.out.println("The card:");
                    name = sc.nextLine();
                    if (stack.containsKey(name)) {
                        System.out.println(String.format("The card \"%s\" already exists.", name));
                        break;
                    } else {
                        System.out.println("The definition of the card:");
                        def = sc.nextLine();
                        if (stack.containsValue(def)) {
                            System.out.println(
                                String.format("The definition \"%s\" already exists.", def));
                        } else {
                            stack.put(name, def);
                            order.add(name);
                            index++;
                            System.out.println(String
                                .format("The pair (\"%s\":\"%s\") has been added.", name, def));
                        }
                    }
                    break;

                case "remove":
                    System.out.println("The card:");
                    name = sc.nextLine();
                    if (!stack.containsKey(name)) {
                        System.out.println(
                            String.format("Can't remove \"%s\": there is no such card.", name));
                    } else {
                        for (int i = 0; i < order.size(); i++) {
                            if (order.get(i).equals(name)) {
                                order.remove(i);
                            }
                        }
                        stack.remove(name);
                        System.out.println("The card has been removed.");
                    }
                    break;

                case "exit":
                    System.out.println("Bye bye!");
                    stop = true;
                    break;

                case "export":
                    System.out.println("File name:");
                    file = sc.nextLine();
                    add = 0;
                    try {
                        BufferedWriter out = Files
                            .newBufferedWriter(Paths.get(file), StandardCharsets.UTF_8);
                        for (int i = 0; i < order.size(); i++) {
                            out.write(order.get(i) + ';' + stack.get(order.get(i)) + System
                                .lineSeparator());
                            add++;
                        }
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                    System.out.println(String.format("%d cards have been saved.", add));
                    break;

                case "import":
                    System.out.println("File name:");
                    file = sc.nextLine();
                    add = 0;
                    try {
                        BufferedReader in = Files
                            .newBufferedReader(Paths.get(file), StandardCharsets.UTF_8);
                        String line;

                        while ((line = in.readLine()) != null) {
                            if (stack.containsKey(line.split(";")[0])) {
                                stack.remove(line.split(";")[0]);
                            } else {
                                order.add(line.split(";")[0]);
                            }
                            add++;
                            stack.put(line.split(";")[0], line.split(";")[1]);
                        }
                        System.out.println(String.format("%d cards have been loaded.", add));
                        in.close();
                    } catch (IOException e) {
                        System.out.println("File not found");
                    }
                    break;

                case "ask":
                    Object[] keys = stack.keySet().toArray();
                    System.out.println("How many times to ask?");
                    int times = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < times; i++) {
                        int rnd = (int) (Math.random() * ((order.size() - 1) + 1));
                        System.out.println(
                            String.format("Print the definition of \"%s\":", order.get(rnd)));
                        String in = sc.nextLine();
                        if (in.equals(stack.get(order.get(rnd)))) {
                            System.out.println("Correct answer.");
                        } else {
                            if (stack.containsValue(in)) {
                                for (int j = 0; j < keys.length; j++) {
                                    if (stack.get(keys[j].toString()).equals(in)) {
                                        System.out.println(String.format(
                                            "Wrong answer, The correct one is \"%s\", you've just written the "
                                                + "definition of \"%s\"", stack.get(order.get(rnd)),
                                            keys[j].toString()));
                                    }
                                }
                            } else {
                                System.out.println(String
                                    .format("Wrong answer. The correct one is \"%s\".",
                                        stack.get(order.get(rnd).toString())));
                            }
                        }
                    }

            }
        }
    }
}