import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("Ivan", 23, new Address("Mira", 10));
        Person p2 = new Person("Mariya", 10, new Address("Pushkina", 29));
        Person p3 = new Person("Moshe", 120, new Address("Tov", 7));
        Person p4 = new Person("Vova", 16, new Address("Pobedu", 4));

        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        System.out.println(addressesOfPerson17(persons));

        List<String> names= Arrays.asList("Tom","Potap","Anna","Olga","Anna","Tom");
        System.out.println(noNamesDublicat(names));
        Person a1=new Person("Ivan",20);
        Person a2=new Person("Mariya",20);
        Person a3=new Person("Vova",12);
        Person a4=new Person("Ivan2",25);
        Person a5=new Person("Pyotr",12);
        Person a6=new Person("Filip",10);
        Person a7=new Person("Ivan3",0);

        List<Person>agePerson=new ArrayList<>();
        agePerson.add(a1);
        agePerson.add(a2);
        agePerson.add(a3);
        agePerson.add(a4);
        agePerson.add(a5);
        agePerson.add(a6);
        agePerson.add(a7);


        BankAccount ba1=new BankAccount("12344321", a1);
        BankAccount ba2=new BankAccount("345677654",a2);
        BankAccount ba3=new BankAccount("89543789",new Person("Fenya"));
        BankAccount ba4=new BankAccount("78945345",a5);
        BankAccount ba5=new BankAccount("34432234",a1);
        BankAccount ba6=new BankAccount("34432254334",a1);
        BankAccount ba7=new BankAccount("34432132234",a2);

        List<BankAccount> bankAccountsList=Arrays.asList(ba1,ba2,ba3,ba4,ba5,ba6,ba7);
        String sentence="or mutable sources, arbitrary and non-deterministic behavior may occur if the source is structurally interfered with (elements added, replaced, or removed) between the time that the Spliterator binds to its data source and the end of traversal. For example, such interference will produce arbitrary, non-deterministic results when using the java.util.stream framework.";

        Person person1=new Person("ivan",Arrays.asList(new BankAccount("567324532"),new BankAccount("7634892654"), new BankAccount("78934268432632")));
        Person person2=new Person("Pyiotr",Arrays.asList(new BankAccount("77999944444"),new BankAccount("88855554335454")));
        Person person3=new Person("MAruya", Arrays.asList(new BankAccount("22332423434343"),new BankAccount("4329-0432542")));

        List<Person> personListAccountsWithStars=new ArrayList<>();
        personListAccountsWithStars.add(person1);
        personListAccountsWithStars.add(person2);
        personListAccountsWithStars.add(person3);

        System.out.println("Map for age");
        System.out.println(peopleAge(agePerson));
        System.out.println("Map for BAnk Accounts");
        System.out.println(bankAccountsOfPerson(bankAccountsList));
        System.out.println("Changing Accounts");
        System.out.println(changedBankAccounts(bankAccountsList));

        System.out.println("\"Sentence\"");
        System.out.println(countWordsWithChar(sentence,"a"));

        System.out.println("Persons with accounts with stars");
        System.out.println(personsAccountsWithStars(personListAccountsWithStars));

        System.out.println("Sum of ages more than 17");
        System.out.println(sumOfAgesMOreThan17(agePerson));

        System.out.println("Legal Age");
        System.out.println(legalAges(agePerson));




    }
        public static List<Address> addressesOfPerson17(List<Person>persons){
            return persons.
                    stream()
                    .filter(p -> p.getAge() > 17)
                    .map(Person::getAddress)
                    .collect(Collectors.toList());
        }

        public static Set<String> noNamesDublicat(List<String> names){
            Set<String> namesSet=
            names.stream().collect(Collectors.toSet());
            return namesSet;
        }

        public static Map<Integer,List<Person>> peopleAge(List<Person> people){
          Map<Integer,List<Person>> peopleMap = people
                    .stream()
                    .collect(groupingBy(Person::getAge));

            peopleMap.forEach((k,v)->{
              System.out.println(k+"key"+"value"+v);
            });
            return peopleMap;
        }

        public static Map<Person,List<String>> bankAccountsOfPerson(List<BankAccount> bankAccountList){
            /*for (BankAccount bankAccount : bankAccountList) {
                String ibann = bankAccount.getIBANN();
                personsAccounts.computeIfAbsent(bankAccount.getOwner(), key -> new ArrayList<>()).add(ibann);
            }*/

            //.collect(Collectors.groupingBy(BankAccount::getOwner));
            Map<Person, List<String>> personsAccounts = bankAccountList.stream()
                    .collect(groupingBy(BankAccount::getOwner, mapping(BankAccount::getIBANN, toList())));

        personsAccounts.forEach((k,v)->{
            System.out.println(k+"Bank Account"+ "Owner"+v);
        });

        return personsAccounts;
        }

        public static List<String> changedBankAccounts(List<BankAccount> accountInput){
        List<String> changedAccounts=accountInput
                .stream()
                .map(BankAccount::getIBANN)
                .map(s->changinWithStars(s))
                .collect(Collectors.toList());
        return changedAccounts;

        }

        public static String changinWithStars(String ibann){
        return ibann.substring(0,3)+ibann.substring(3).replaceAll("\\d","*");
        }


        public static long countWordsWithChar(String inputSentence, String input){
        List<String> asArrayList=Arrays.asList(inputSentence.split(" "));
            long count = asArrayList.stream().map(s -> s.toLowerCase()).filter(s -> s.startsWith(input)).count();
            return count;

        }

        public static List<String> personsAccountsWithStars(List<Person> input){
             return    input.stream()
                        .flatMap(p->p.getBankAccounts().stream())
                        .map(a->a.getIBANN())
                        .map(a->changinWithStars(a))
                        .collect(Collectors.toList());

        }
        public static int sumOfAgesMOreThan17(List<Person> input){
            Integer reduce = input.stream()
                    .filter(p -> p.getAge() > 17)
                    .reduce(0, (personAge, z) -> personAge + z.getAge(), Integer::sum);


            return reduce;

        }

    public static String legalAges(List<Person>input){
        return input.stream()
                .filter(p->p.getAge()>17)
                .map(p->p.getName())
                .collect(Collectors.joining(" ","In Germany "," are of legal age"));
    }






    }

