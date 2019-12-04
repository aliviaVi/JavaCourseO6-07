public class Counter {
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public synchronized void increment(){
        count ++;
    }

    public synchronized void decrement(){
        count --;
    }

    public synchronized int getCountValue(){
        return count;
    }
}
