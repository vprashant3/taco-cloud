package com.AlogrithmsAndDataStructures.Datastructures;

public class DoublyLinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return  data.toString();
        }
    }

    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.prev =  trav.next  = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size =0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(T elem) {
        addLast(elem);
    }

    public void addFirst(T elem) {
        if(isEmpty()) {
            head = tail = new Node<>(elem, null, null);
        } else {
            head.prev = new Node<>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addLast(T elem) {
        if(isEmpty()) {
            head = tail = new Node<>(elem, null, null);
        } else {
            tail.next = new Node<>(elem, tail, null);
            tail = tail.next;
        }
        size++;

    }

    public T peekFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        return head.data;
    }

    public T peekLast() {
        if(isEmpty()) throw new RuntimeException("Empty List");
        return tail.data;
    }

    public T removeFirst() {
        if(isEmpty()) throw new RuntimeException("Empty List");
        T data = head.data;
        head.next = head;
        size--;

        if(isEmpty()) tail = null;
        else head.prev = null;

        return data;

    }

    public T removeLast() {
        if(isEmpty()) throw new RuntimeException("Empty List");
        T data = tail.data;
        tail.prev = tail;
        size--;

        if(isEmpty()) head = null;
        else tail.next = null;

        return data;
    }


    public T removeNode(Node<T> node) {
        if(node.prev == null) removeFirst();
        if(node.next == null) removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data =  node.data;
        node.data = null;
        node.prev = node.next = null;

        --size;
        return data;

    }


}
