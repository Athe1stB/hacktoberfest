public class ExampleSubclass extends Example {

    {
        step(11);
    }

    public static int step_3 = step(3);
    public int step_12 = step(12);

    static {
        step(4);
    }

    public ExampleSubclass(int unused) {
        super(step(7));
        step(13);
    }

    public static void main(String[] args) {
        step(5);
        new ExampleSubclass(step(6));
        step(14);
    }
}
