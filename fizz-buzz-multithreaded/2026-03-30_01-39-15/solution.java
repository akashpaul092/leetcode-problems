class FizzBuzz {
    private int n;
    private Semaphore fizzPermit;
    private Semaphore buzzPermit;
    private Semaphore fizzbuzzPermit;
    private Semaphore numberPermit;
    
    public FizzBuzz(int n) {
        this.n = n;
        this.fizzPermit = new Semaphore(0);
        this.buzzPermit = new Semaphore(0);
        this.fizzbuzzPermit = new Semaphore(0);
        this.numberPermit = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i=1; i<= n; i++){
            if(i % 3 == 0 && i % 5 != 0 ){
                fizzPermit.acquire();
                printFizz.run();
                numberPermit.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i=1; i<= n; i++){
            if(i % 3 != 0 && i % 5 == 0 ){
                buzzPermit.acquire();
                printBuzz.run();
                numberPermit.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i=1; i<= n; i++){
            if(i % 3 == 0 && i % 5 == 0 ){
                fizzbuzzPermit.acquire();
                printFizzBuzz.run();
                numberPermit.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<= n; i++){
            numberPermit.acquire();
            if(i % 3 == 0 && i % 5 == 0 ){
                fizzbuzzPermit.release();
            }else if(i % 3 == 0 && i % 5 != 0 ){
                fizzPermit.release();
            }else if(i % 3 != 0 && i % 5 == 0 ){
                buzzPermit.release();
            }else{
                printNumber.accept(i);
                numberPermit.release();
            }
        }
    }
}