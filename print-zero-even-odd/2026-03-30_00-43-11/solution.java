class ZeroEvenOdd {
    private int n;
    private Semaphore zeroPermit;
    private Semaphore evenPermit;
    private Semaphore oddPermit;  

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zeroPermit = new Semaphore(1);
        this.evenPermit = new Semaphore(0);
        this.oddPermit = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i++){
            zeroPermit.acquire();
            printNumber.accept(0);

            if(i%2 == 0){
                evenPermit.release();
            }else{
                oddPermit.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2){
            evenPermit.acquire();
            printNumber.accept(i);
            zeroPermit.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2){
            oddPermit.acquire();
            printNumber.accept(i);
            zeroPermit.release();
        }
    }
}