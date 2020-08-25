public class Preveri23 {

    private static SeznamiUV s;

    private static void run(String a) {
        System.out.println(a + " : " + s.processInput(a));
    }

    public static void main(String[] args) {

        s = new SeznamiUV();

        run("use 23");

        run("add 1");
        run("add 2");
        run("add 3");
        run("add 4");
        run("add 5");
        run("add 6");
        run("add 7");
        run("add 8");
        run("add 9");
        run("add 10");
        run("asList");

        run("size");

        run("depth");

        run("is_empty");

        run("getfirst");

        run("exists 7");

        run("remove_first");
        run("asList");

        run("remove_first");
        run("asList");

        run("remove 2");
        run("asList");

        run("remove 3");
        run("asList");

        run("reset");
        run("add 8");
        run("asList");
    }
}