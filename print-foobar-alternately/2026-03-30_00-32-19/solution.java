class FooBar {
    private int n;
    private Semaphore fooPermit;
    private Semaphore barPermit;
    public FooBar(int n) {
        this.n = n;
        this.fooPermit = new Semaphore(1);
        this.barPermit = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            fooPermit.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            barPermit.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            barPermit.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            fooPermit.release();
        }
    }
}