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
        Map<String, Integer> mistakes = new HashMap<String, Integer>();
        String name = "";
        String def = "";
        ArrayList<String> order = new ArrayList<String>();
        int index = 0;
        boolean stop = false;
        String file;
        int add;
        int count = 0;
        ArrayList<String> log = new ArrayList<String>();
        Map<String, Integer> highestMistakes = new HashMap<String, Integer>();

        while (!stop) {
            System.out.println(
                "Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
            String act = sc.nextLine();
            log.add(act);
            switch (act) {
                case "hardest card":
                    int currentHigh = 0;

                    count++;

                    try {
                        for (int i = 0; i < order.size(); i++) {
                            if (mistakes.get(order.get(i)) > currentHigh) {
                                highestMistakes.clear();
                                highestMistakes.put(order.get(i), mistakes.get(order.get(i)));
                                currentHigh = mistakes.get(order.get(i));
                            } else if (mistakes.get(order.get(i)) == currentHigh) {
                                highestMistakes.put(order.get(i), mistakes.get(order.get(i)));
                            }
                        }
                    } catch (NullPointerException e) {
                        System.out.println("There are no cards with errors." + count);
                        break;
                    }
                    if (currentHigh == 0) {
                        System.out.println("There are no cards with errors." + count);
                        break;
                    }
                    String errors = "";
                    String end = "";
                    Object[] keysM = highestMistakes.keySet().toArray();
                    if (keysM.length == 1) {
                        errors += "card is ";
                        end += "it";
                    } else {
                        errors += "cards are ";
                        end += "them";
                    }
                    for (int i = 0; i < keysM.length; i++) {
                        errors += "\"" + keysM[i].toString() + "\"";
                        if (i != keysM.length - 1) {
                            errors += ", ";
                        } else {
                            errors += '.';
                        }
                    }
                    System.out.println(String
                        .format("The hardest %s You have %d errors answering %s.", errors,
                            currentHigh, end));
                    break;

                case "reset stats":
                    currentHigh = 0;
                    highestMistakes.clear();
                    for (int i = 0; i < mistakes.size(); i++) {
                        mistakes.put(order.get(i), 0);
                    }
                    System.out.println("Card statistics has been reset.");
                    break;

                case "log":
                    System.out.println("File name:");
                    file = sc.nextLine();
                    log.add(file);
                    try {
                        BufferedWriter out = Files
                            .newBufferedWriter(Paths.get(file), StandardCharsets.UTF_8);
                        for (int i = 0; i < log.size(); i++) {
                            out.write(log.get(i) + System.lineSeparator());
                        }
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                    System.out.println("The log has been saved.");
                    break;

                case "add":
                    String[][] card = new String[stack.size()][2];
                    System.out.println("The card:");
                    name = sc.nextLine();
                    log.add(name);
                    if (stack.containsKey(name)) {
                        System.out.println(String.format("The card \"%s\" already exists.", name));
                        break;
                    } else {
                        System.out.println("The definition of the card:");
                        def = sc.nextLine();
                        log.add(def);
                        if (stack.containsValue(def)) {
                            System.out.println(
                                String.format("The definition \"%s\" already exists.", def));
                        } else {
                            stack.put(name, def);
                            order.add(name);
                            mistakes.put(name, 0);
                            index++;
                            System.out.println(String
                                .format("The pair (\"%s\":\"%s\") has been added.", name, def));
                        }
                    }
                    break;

                case "remove":
                    System.out.println("The card:");
                    name = sc.nextLine();
                    log.add(name);
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
                    log.add(file);
                    add = 0;
                    try {
                        BufferedWriter out = Files
                            .newBufferedWriter(Paths.get(file), StandardCharsets.UTF_8);
                        for (int i = 0; i < order.size(); i++) {
                            out.write(order.get(i) + ';' + stack.get(order.get(i)) + ';' + mistakes
                                .get(order.get(i)) + System.lineSeparator());
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
                    log.add(file);
                    add = 0;
                    try {
                        BufferedReader in = Files
                            .newBufferedReader(Paths.get(file), StandardCharsets.UTF_8);
                        String line;

                        while ((line = in.readLine()) != null) {
                            if (!stack.containsKey(line.split(";")[0])) {
                                order.add(line.split(";")[0]);
                            }
                            add++;
                            stack.put(line.split(";")[0], line.split(";")[1]);
                            mistakes.put(line.split(";")[0], Integer.parseInt(line.split(";")[2]));
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
                    log.add(Integer.toString(times));
                    for (int i = 0; i < times; i++) {
                        int rnd = (int) (Math.random() * ((order.size() - 1) + 1));
                        System.out.println(
                            String.format("Print the definition of \"%s\":", order.get(rnd)));
                        String in = sc.nextLine();
                        log.add(in);
                        if (in.equals(stack.get(order.get(rnd)))) {
                            System.out.println("Correct answer.");
                        } else {
                            try {
                                mistakes.put(order.get(rnd), mistakes.get(order.get(rnd)) + 1);
                            } catch (NullPointerException ee) {
                                mistakes.put(order.get(rnd), 1);
                            }
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