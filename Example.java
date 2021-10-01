public class Example {

    static {
        step(1);
    }

    public static int step_2 = step(2);
    public int step_8 = step(8);

    public Example(int unused) {
        super();
        step(10);
    }

    {
        step(9);
    }

    // Just for demonstration purposes:
    public static int step(int step) {
        System.out.println("Step " + step);
        return step;
    }
}
