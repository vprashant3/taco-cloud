package com.AlogrithmsAndDataStructures.Datastructures;

public class BinarySearchTree<T extends Comparable<T>> {

    private int nodeCount;
    private Node root;


    private class Node {
        T data;
        Node left, rght;
        public Node(Node left, Node right, T elem) {
            this.left = left;
            this.rght = right;
            this.data =  elem;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int size() {
        return nodeCount;
    }

    public boolean add(T elem) {
        if(contains(elem)) return false;
        else {
            root = add(root, elem);
            nodeCount++;
            return true;
        }
    }

    private Node add(Node node, T elem) {
        if(node == null) {
            node = new Node(null, null, elem);
        } else {
               if(elem.compareTo(node.data)<0) {
                   node.left = add(node.left, elem);
               } else {
                   node.rght = add(node.rght, elem);
               }
        }
        return node;
    }

    public boolean remove(T elem) {
        if(contains(elem))  {
            root =  remove(root, elem);
            nodeCount--;
            return true;
        } else return false;

    }

    private Node remove(Node node, T elem) {
        if(node == null) return null;

        int cmp =  elem.compareTo(node.data);

        if(cmp < 0) {
            node.left = remove(node.left, elem);
        }else if(cmp > 0) {
            node.rght = remove(node.rght, elem);
        }else {
            if(node.left == null) {
                Node rightChild =  node.rght;
                node.data = null;
                node = null;
                return rightChild;
            } else if(node.rght == null) {
                Node leftChild =  node.left;
                node.data =  null;
                node =  null;
                return leftChild;
            } else {
                Node tmp =  digLeft(node.rght);
                node.data = tmp.data;
                node.rght = remove(node.rght, tmp.data);
            }
        }
        return node;
    }

    private Node digLeft(Node node) {
        Node cur = node;
        while(cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public boolean contains(T elem) {
        return contains(root, elem);
    }

    private boolean contains(Node node, T elem) {
        if(node == null) return false;

        int cmp = elem.compareTo(node.data);

        if(cmp < 0) {
           return contains(node.left, elem);
        } else if( cmp > 0) {
            return contains(node.rght, elem);
        } else return true;
     }


}
