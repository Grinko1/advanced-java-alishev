package org.example.collections.linked_list;

import java.util.Arrays;

public class OwnLinkedList {
    private Node head;
    private int size;

    public void add(int value) {
        if (head == null) {
            this.head = new Node(value);
        } else {
            Node tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(new Node(value));
        }

        size++;
    }
    public void remove(int idx){
        if(idx ==0){
            head = head.getNext();
            size--;
            return;
        }
        int index = 0;
        Node tmp = head;
        while (tmp != null) {

            if ((index + 1)== idx) {
                tmp.setNext(tmp.getNext().getNext());
                size--;
                return;
            } else {
                tmp = tmp.getNext();
                index++;
            }
        }

    }

    public int get(int idx) {
        int index = 0;
        Node tmp = head;
        while (tmp != null) {

            if (index == idx) {
                return tmp.getValue();
            } else {
                tmp = tmp.getNext();
                index++;
            }

        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        int[] result = new int[size];
        Node tmp = head;
        int idx = 0;
        while (tmp != null) {
            result[idx++] = tmp.getValue();
            tmp = tmp.getNext();


        }

        return Arrays.toString(result);
    }

    private static class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
