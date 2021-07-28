package Test;

public class Test {
    private int x = 1;
    private class TestA{
        public void func() {
            System.out.println(x);
        }
    }

    public void func() {
        TestA a = new TestA();
        a.func();
    }

    public static void main(String args[]) {
        Test test = new Test();
        test.func();
    }
}
