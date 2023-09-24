import javax.swing.*;

public class Person implements Comparable<Person>{
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        checkAge(age);
        this.age = age;
    }

    private void checkAge(int age) throws InvalidAgeException{
        if (this.age == null) {
            throw new InvalidAgeException("Age not set");
        }
        else if (this.age < 0) {
            throw new InvalidAgeException("Age below set to below zero");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age, String name)  {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Person o) {
        return  this.getName().compareTo(o.getName());
    }
}
