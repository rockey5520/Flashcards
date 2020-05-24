class Application {

    String name;

    void run(String[] args) {
        System.out.println(name);
        for (String s: args
        ) {
            System.out.println(s);
        }
    }
}