package org.example.collections.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(3);
        list.add(5);
        list.add(2);

        //old method
        Iterator<Integer> iterator = list.iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            if(idx == 1){
                iterator.remove();
            }

            idx++;

        }
        System.out.println(list);
        // inside use iterator
//        for (int x : list) {
//
////                list.remove(2);
//
//            System.out.println(x);
//        }
    }
}
