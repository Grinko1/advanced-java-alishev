package org.example.collections.linked_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        //all methods equal arrayList
//        measureTime(linkedList);
//        measureTime(arrayList);
        OwnLinkedList myLinkedList = new OwnLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        System.out.println(myLinkedList + " before delete");
        myLinkedList.remove(0);
        System.out.println(myLinkedList + " after delete");



    }
    private static void measureTime (List<Integer> list){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(0,i);
        }

//        for (int i = 0; i < list.size(); i++) {
//            list.get(i);
//        }
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end-start));

    }
}
