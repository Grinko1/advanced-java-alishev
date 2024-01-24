package org.example.collections.hash_map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test2 {
    public static void main(String[] args) {
        //нет порядка сохранения и вывода
        Map<Integer, String> hashMap = new HashMap<>();
        //сохраняет и возвращает в порядке
        Map<Integer, String> linkedHash = new LinkedHashMap<>();
        // ключ:значение будут отсортированы по ключу
        Map<Integer, String> treeMap = new TreeMap<>();
        testMap(hashMap);
        testMap(linkedHash);
        testMap(treeMap);

//        System.out.println(hashMap);
//        System.out.println(linkedHash);
//        System.out.println(treeMap);
    }
    public static void testMap(Map <Integer,  String> map){
        map.put(34, "Faust");
        map.put(23, "Musyas");
        map.put(75, "Knopa");
        map.put(43, "Markiza");

        map.put(334, "Zissa");
        map.put(83, "Bobik");
        map.put(41, "Charlik");
        map.put(98, "Linda");
        map.put(56, "Shanti");
        map.put(69, "Choma");
        map.put(53, "Eva");
        map.put(95, "Sharik");
        for (Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println(entry.getKey()+" : "+ entry.getValue());

        }
        System.out.println("-----------");
    }
}
