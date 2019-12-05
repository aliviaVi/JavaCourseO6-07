public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter count=new Counter(0);



        Runnable myThread1 = ()->{
        for (int i = 0; i <10 ; i++) {
            count.increment();
            System.out.println(count.getCountValue()+ " value from increment");
        }

        };
        myThread1.run();
        Thread t1=new Thread(myThread1);
        t1.start();

        Runnable myThread2=()->{
            for (int i = 0; i <10 ; i++){
                count.decrement();
                System.out.println(count.getCountValue()+ " value from decrement");
            }
        };
        myThread2.run();
        Thread t2=new Thread(myThread2);
        t2.start();

        t1.join();
        t2.join();


        System.out.println(count.getCountValue()+ " value from Main");
    }
}
