import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person1, person2, person3;

        person1 = new Person(12, "jan");
        person2 = new Person(10, "anna");
        person3 = new Person(30, "piotr");

        try {
            person1.setAge(-12);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        List<Person> pList = new ArrayList<>();
        pList.add(person1);
        pList.add(person2);
        pList.add(person3);

        Set<Person> pSet = new HashSet<>(); // set nie pozwala na duplikowanie elementów, unordered
        pSet.add(person1);
        pSet.add(person2);
        pSet.add(person3);

        Map<Integer, Person> pMap = new HashMap<>();
        pMap.put(10, person1);
        pMap.put(20, person2);
        pMap.put(30, person3);

        System.out.println("Lista: " + pList);
        System.out.println("Set: " + pSet);
        System.out.println("Mapa: " + pMap);

        List<Integer> ageList = pList.stream().map(Person::getAge).toList();
        Integer ageAverage = ageList.stream().reduce(0, Integer::sum);

        List<String> nameList = pList.stream().map(Person::getName).toList();

        List<Person> pplOver25 = pList.stream().filter( person -> person.getAge() > 25).toList();

        pList.sort(Person::compareTo);

        pList.forEach(person -> System.out.println(person.toString()));

        Optional<Person> personMinAge = pList.stream().min((p1,p2) -> Integer.compare(p1.getAge(),p2.getAge()));
        Optional<Person> personMaxAge = pList.stream().max((p1,p2) -> Integer.compare(p1.getAge(),p2.getAge()));
        System.out.println(personMinAge.isEmpty()? "min Not Found": personMinAge );
        System.out.println(personMaxAge.isEmpty()? "max Not Found": personMaxAge );

    }

}