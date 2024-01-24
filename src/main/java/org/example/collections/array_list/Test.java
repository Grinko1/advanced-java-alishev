package org.example.collections.array_list;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
//        System.out.println(list);
//        System.out.println(list.get(8));
//        System.out.println(list.size());
        list.remove(5);
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
        }
        List<Car> list2 = new ArrayList<>();
        list2.add(new Car("red","audi"));
        list2.add(new Car("Black", "bmv"));
        System.out.println(list2);
    }
}

class Car{
    private String color;
    private String brand;

    public Car(String color, String brand) {
        this.color = color;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}