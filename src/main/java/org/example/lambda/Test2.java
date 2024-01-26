package org.example.lambda;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Apchii");

        list.sort((a,b) ->a.length() -b.length() );
        System.out.println(list);
    }
}
