public class BankAccount {
    private String IBANN;
    private Person owner;

    public BankAccount(String IBANN, Person owner) {
        this.IBANN = IBANN;
        this.owner = owner;
    }
    public BankAccount (String IBANN){
        this.IBANN=IBANN;
    }


    public String getIBANN() {
        return IBANN;
    }

    public Person getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "IBANN='" + IBANN + '\'' +
                ", owner=" + owner +
                '}';
    }
}
