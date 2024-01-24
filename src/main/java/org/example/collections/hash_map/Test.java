package org.example.collections.hash_map;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(null,"any");
        //нет порядка каждый раз будет выдавать в разном порядке
       for (Map.Entry<Integer, String> entry: map.entrySet()){
           System.out.println(entry.getKey() +" : "+ entry.getValue());

        }
    }
}
