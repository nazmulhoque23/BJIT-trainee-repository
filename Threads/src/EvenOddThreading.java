class NumberObject{
    Integer i;
    public NumberObject(Integer i){
        this.i = i;
    }
    public Integer increment(){
        return this.i +=1;
    }
}

class EvenNumbers implements Runnable{
    public NumberObject num;
    //Integer num
    int n;

    public EvenNumbers(NumberObject num, int n){//(Integer num, int n)
        this.num = num;
        this.n = n;
    }
    public void run(){
        while(num.i<n){//(num<n)
            synchronized (num){
                while(num.i % 2 == 1){
                    try{
                        num.wait();
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("Even thread:"+num.i);
                num.increment();
                num.notifyAll();
            }
        }
    }
}

class OddNumbers implements Runnable{

    NumberObject num;
    int n;

    public OddNumbers(NumberObject num, int n) {//(Integer num, int n)
        this.num = num;
        this.n = n;
    }
    public void run(){
        while(num.i<n){//(num<n)
            synchronized (num){
                while(num.i % 2 == 0){
                    try{
                        num.wait();
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("Odd thread:"+num.i);
                num.increment();
                num.notifyAll();
            }
        }
    }

}
public class EvenOddThreading {
    public static void main(String[] args){
        int n = 10;
        NumberObject num = new NumberObject(1);
        Object number = 1;
//        if(number<10)
//        System.out.println(number.getClass());
        OddNumbers on = new OddNumbers(num, n);
        EvenNumbers en = new EvenNumbers(num, n);

        Thread oddThread = new Thread(on);
        Thread evenThread= new Thread(en);

        evenThread.start();
        oddThread.start();
    }
}
