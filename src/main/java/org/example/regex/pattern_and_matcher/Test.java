package org.example.regex.pattern_and_matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String text = """
                Hello, guys! I send you my emailjoe@mail.com so we can
                keep in touch.  Thanks, joe! Thanks cool. I am sending you
                my address tim@yandex.ru. Lets stay in touch...""";

        Pattern email = Pattern.compile("(\\w+)@(yandex|mail|gmail)\\.(com|ru)");
        Matcher matcher = email.matcher(text);

       /*
       в matcher.group() можно передавать номер группы, за группу считается обворнутая () часть
      (\\w+)@(yandex|mail|gmail)\\.(com|ru)" -
        (\\w+) - если обернуть (\\w+) то это будет первая группа
        (yandex|mail|gmail) - и так в скобках, 2 группа
        (com|ru) - 3 группа
        matcher.group(1) - вернет emailjoe и  tim
        matcher.group(2) - mail и yandex
        matcher.group(3) - com и ru
        matcher.group() - вернет всю строку

        */


        while(matcher.find()){
            System.out.println(matcher.group());
        }

    }
}
