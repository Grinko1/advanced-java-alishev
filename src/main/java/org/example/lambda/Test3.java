package org.example.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        List<Integer> list = new ArrayList<>();
        fillArray(arr);
        fillList(list);
        System.out.println("arr- " + Arrays.toString(arr));
        System.out.println("list- " + list);

//        for (int i = 0; i < 10; i++) {
//            arr[i] = arr[i]*2;
//            list.set(i, list.get(i) *2);
//        }


        // map
//        arr = Arrays.stream(arr).map(i -> i * 2).toArray();
//        list = list.stream().map(i -> i * 2).collect(Collectors.toList());

        //reduce
//        int sum = Arrays.stream(arr).reduce((acc,cur)->acc+cur).getAsInt();
        int sum = list.stream().reduce(Integer::sum).get();

        System.out.println("sum "+sum);

        // filter
//       arr= Arrays.stream(arr).filter(a-> a%2==0).toArray();
//       list = list.stream().filter(a->a%2==1).collect(Collectors.toList());

        //foreach
//       Arrays.stream(arr).forEach(System.out::println);
//        list.forEach(System.out::println);
        System.out.println("arr- " + Arrays.toString(arr));
        System.out.println("list- " + list);


    }

    private static void fillArray(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }
}
