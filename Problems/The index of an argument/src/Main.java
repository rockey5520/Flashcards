class Problem {

  public static void main(String[] args) {
    int counter = -1;
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("test")) {
        counter = i;
        System.out.println(counter);
        System.exit(0);
      }
    }
    System.out.println(counter);
  }
}