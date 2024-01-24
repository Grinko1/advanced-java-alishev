package org.example.collections.stack;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(4);
//        System.out.println(stack.pop());  -delete and return first el
//        System.out.println(stack.peek()); - show last el
        while(!stack.empty()){
            System.out.println(stack.pop());
        }



    }
}
