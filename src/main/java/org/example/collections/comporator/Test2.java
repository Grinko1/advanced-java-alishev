package org.example.collections.comporator;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        List<OnePerson> personList = new ArrayList<>();
        Set<OnePerson> personSet = new TreeSet<>();
        addElements(personList);
        addElements(personSet);
        Collections.sort(personList);

        System.out.println(personList);
        System.out.println("-------");
        System.out.println(personSet );
    }

    private static void addElements(Collection<OnePerson> collection) {

        collection.add(new OnePerson(3, "Knopa"));
        collection.add(new OnePerson(4, "Mysya"));
        collection.add(new OnePerson(1, "Faust"));
        collection.add(new OnePerson(5, "Nora"));
        collection.add(new OnePerson(2, "Markiza"));
    }
}

class OnePerson implements Comparable<OnePerson> {
    private int id;
    private String name;

    public OnePerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "OnePerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnePerson onePerson = (OnePerson) o;
        return getId() == onePerson.getId() && Objects.equals(name, onePerson.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name);
    }



    @Override
    public int compareTo(OnePerson o) {
        return this.id - o.id;
    }
}