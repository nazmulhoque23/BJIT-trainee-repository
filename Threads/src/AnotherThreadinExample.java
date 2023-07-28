public class AnotherThreadinExample {
    int counter = 1;
    static int max;

    public void printEven(){
        synchronized (this){
            while(counter<max){
                while(counter %2 ==1){
                    try{
                        wait();
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("Even thread:"+counter);
                counter++;
                notify();

            }
        }
    }
    public void printOdd(){
        synchronized (this){
            while(counter<max){
                while(counter %2 ==0){
                    try{
                        wait();
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("Odd thread:"+counter);
                counter++;
                notify();

            }
        }
    }
    public static void main(String[] args){
        max =10;
        AnotherThreadinExample at = new AnotherThreadinExample();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                at.printEven();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                at.printOdd();
            }
        });
        t1.start();
        t2.start();
    }
}
