package com.sparta.jm.model;

public class Node {
    private Node left;
    private Node right;
    private final int value;

    public Node(int n) {
        value = n;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

}
