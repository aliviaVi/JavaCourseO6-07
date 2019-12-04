public class Counter {
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public void increment(){
        count ++;
    }

    public void decrement(){
        count --;
    }

    public int getCountValue(){
        return count;
    }
}
