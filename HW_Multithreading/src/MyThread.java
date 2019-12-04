public class MyThread implements Runnable {
    private Counter count;
   // Thread t;

    public MyThread(Counter count) {
        this.count = count;
       /* t=new Thread();
        t.start();*/
    }


    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            count.increment();
            System.out.println(count.getCountValue()+ " value from increment");
            count.decrement();
            System.out.println(count.getCountValue()+ " value from decrement");
        }

    }
}
