class Foo {
    private volatile int step = 1;

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        step = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (step != 2);
        printSecond.run();
        step = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (step != 3);
        printThird.run();
    }
}
