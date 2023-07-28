class EvenOddFind implements Runnable{
    static int counter = 1;
    public int max = 10;
    int remainder;

    static Object lock = new Object();
    public EvenOddFind(int remainder){
        this.remainder = remainder;
    }
    public void run(){
        while(counter<max){
            synchronized (lock){
                while(counter % 2 != remainder){
                    try{
                        lock.wait();
                    }catch (InterruptedException e){
                        e.getMessage();
                    }
                }
                System.out.println(Thread.currentThread().getName()+":"+counter);
                counter++;
                lock.notifyAll();
            }
        }
    }

}


public class EvenOddExample {
    public static void main(String[] args){
        EvenOddFind on = new EvenOddFind(1);
        EvenOddFind en = new EvenOddFind(0);

        Thread t1  = new Thread(on, "Odd Thread");
        Thread t2 = new Thread(en, "Even Thread");

        t1.start();
        t2.start();
    }
}
