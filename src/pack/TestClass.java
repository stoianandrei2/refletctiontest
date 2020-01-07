package pack;

public class TestClass {
    private static int staticNum = 12;
    private static String staticString = "Static string";
    private int nonStaticInt;


    public static String getStaticString () {
        return staticString;
    };

    public int getNonStaticInt() {
        return nonStaticInt;
    }

    public void setNonStaticInt(int nonStaticInt) {
        this.nonStaticInt = nonStaticInt;
    }

    public void printSomething () {
        System.out.println("Printing something");
    }

}
