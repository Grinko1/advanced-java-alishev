package org.example.regex;

public class Test {
    public static void main(String[] args) {
        /*
         \\d - 1 цифра
         \\w - 1 любая буква эквивалентно  [a-zA-Z]
         \\d+ - 1 или более
         \\d* - 0 или более
         -\\d - отрицательные числа
         ? - 0 или 1 символ до
         -?\\d - true отрицательные и положительные
         (-|\\+) or ([-+]) - одно из переданного true, плюс нужно экранировать
         [a-zA-Z] - одна из всеч английских букв
         [a-zA-Z]+ - любое к-во английских букв
         [^abc]* - ^ -отрицание, все символы кроме abc
         . - любой символ
         .+ - любое к-во символов
         {2} - 2 символа до
         {2,} - 2 и более символов
         {2,4} - от 2 до 4

        * */

//        String a = "+1234";
//        String b = "-1234";
//        String c = "1234";
//        System.out.println(a.matches("(-|\\+)?\\d+"));
//        System.out.println(b.matches("(-|\\+)?\\d+"));
//        System.out.println(c.matches("([-+])?\\d+"));

//        String d = "Gwererwttwet1234";
//        String e = "Gwererwt435twet1234";
//        System.out.println(d.matches("[a-zA-Z]+\\d+"));
//        System.out.println(e.matches("[a-zA-Z0-9]+"));
//        String q = "ABC";
//        System.out.println(q.matches("[^abc]*"));


//        check url
//        String url = "http://www.google.com";
//        String url2 = "http://www.yandex.ru";
//        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));
//        System.out.println(url2.matches("http://www\\..+\\.(com|ru)"));

//        String s = "123";
//        System.out.println(s.matches("\\d{2,}"));

        String k = "e23";
        System.out.println(k.matches("\\w\\d+"));
    }
}
