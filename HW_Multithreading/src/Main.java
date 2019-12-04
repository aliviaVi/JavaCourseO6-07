public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter count=new Counter(10);

        Runnable myThread1=new MyThread(count);
        Runnable myThread2=new MyThread(count);

        Thread t1=new Thread(myThread1);
        Thread t2=new Thread(myThread2);

        t1.start();
        t1.join();
        t2.start();
        t2.join();

        /*new MyThread(count);
        new MyThread(count);*/


        System.out.println(count.getCountValue()+ " value from Main");
    }
}
