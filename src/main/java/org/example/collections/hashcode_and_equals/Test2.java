package org.example.collections.hashcode_and_equals;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Bob", 1);
        map.put("Katy", 56);
        map.put("Elena", 87);
        System.out.println(map);
    }

}
