package org.example.collections.set;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // random order
        Set<String> hashSet = new HashSet<>();

        // save order additional
        Set<String> linkedSet = new LinkedHashSet<>();
        // natural sort by key
        Set<String> treeSet = new TreeSet<>();

//        testSet(hashSet);

//------------------------------------------

        Set<Integer> hashSet2 = new HashSet<>();
        Set<Integer> hashSet3 = new HashSet<>();
        for (int i = 0; i <= 10; i++) {
            hashSet2.add(i);
        }
        for (int i = 5; i <= 15; i++) {
            hashSet3.add(i);
        }
        //union - обьединение
        Set<Integer> union = new HashSet<>(hashSet2);
        union.addAll(hashSet3);
        System.out.println(union);

        //intersection - пересечение
        Set<Integer> intersection = new HashSet<>(hashSet2);
        intersection.retainAll(hashSet3);
        System.out.println(intersection);

        //difference- разность множеств
        Set<Integer> difference = new HashSet<>(hashSet2);
        difference.removeAll(hashSet3);
        System.out.println(difference);



    }

    public static void testSet(Set<String> set) {
        set.add("Faust");
        set.add("Musyas");
        set.add("Knopa");
        set.add("Markiza");


        set.add("Zissa");
        set.add("Bobik");
        set.add("Charlik");
        set.add("Linda");
        set.add("Shanti");
        set.add("Choma");
        set.add("Eva");
        set.add("Sharik");
//        for (String name : set) {
//            System.out.println(name);
//
//        }
//        System.out.println("-----------");
    }
}
