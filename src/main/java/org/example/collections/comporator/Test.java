package org.example.collections.comporator;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> animal = new ArrayList<>();
        animal.add("guinea pig");
        animal.add("dog");
        animal.add("cat");
        animal.add("rabbit");

        Collections.sort(animal,(a,b) -> a.length() -b.length());
        System.out.println(animal);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(56);
        numbers.add(90);
        numbers.add(24);
        Collections.sort(numbers, (o1, o2) -> o2 -o1);
        System.out.println(numbers);

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Faust"));
        persons.add(new Person(2, "Markiza"));
        persons.add(new Person(3, "Knopa"));
        persons.add(new Person(4, "Mysya"));
        persons.add(new Person(5, "Nora"));
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getId() - o1.getId();
            }
        });
        System.out.println(persons);
    }
}
class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}