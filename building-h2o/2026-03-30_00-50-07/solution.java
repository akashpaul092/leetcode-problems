class H2O {
    private Semaphore hydrogenPermit;
    private Semaphore oxygenPermit;
    public H2O() {
        this.hydrogenPermit = new Semaphore(2);
        this.oxygenPermit = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hydrogenPermit.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxygenPermit.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenPermit.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        hydrogenPermit.release(2);
    }
}