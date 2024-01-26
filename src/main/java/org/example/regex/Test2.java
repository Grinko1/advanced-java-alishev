package org.example.regex;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        String a= "hello.there.hey";
        String[] words = a.split("\\.");
        System.out.println(Arrays.toString(words));

        String replacedWords = a.replaceAll("\\.", " ");
        String replacedFirst = a.replaceFirst("\\." , "-");
        System.out.println(replacedFirst);
        System.out.println(replacedWords);
    }
}
