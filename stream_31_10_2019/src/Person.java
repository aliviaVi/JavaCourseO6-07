import java.util.List;

public class Person {
    private String name;
    private int age;
    private Address address;
    private List<BankAccount> bankAccounts;

    public Person(String name, List<BankAccount> bankAccounts){
        this.name=name;
        this.bankAccounts=bankAccounts;
    }

    public Person(String name){
        this.name=name;
    }

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public Person(String name, int age){
        this.name=name;
        this.age=age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
