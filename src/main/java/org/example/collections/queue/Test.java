package org.example.collections.queue;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    public static void main(String[] args) {
        Person2 p1 = new Person2(2, "Faust");
        Person2 p2 = new Person2(5, "Nora");
        Person2 p3 = new Person2(7, "Knopa");
        Person2 p4 = new Person2(3, "Markiza");

        Queue<Person2> people = new ArrayBlockingQueue<>(3);
//        people.add(p3);
//        people.add(p4);
//        people.add(p1);
//       people.add(p2);
        people.offer(p3);
        people.offer(p4);
        people.offer(p1);
        people.offer(p2);
//        people.remove();
//        people.remove();
//        people.remove();
//        people.poll();
//        people.poll();
//        people.poll();


//        System.out.println(people.peek());


        System.out.println(people);


    }
}

class Person2 implements Comparable<Person2> {
    private int id;
    private String name;

    public Person2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Person2 o) {
        return 0;
    }

}