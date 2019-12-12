package com.sparta.jm.controller;

import com.sparta.jm.model.BinaryTree;
import com.sparta.jm.exceptions.ChildNotFoundException;
import com.sparta.jm.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BinarySearchTree implements BinaryTree {

    private Node root;
    List<Integer> arrayList = new ArrayList<>();

    public BinarySearchTree(int value) {
        root = new Node(value);
    }

    public BinarySearchTree(int[] values) {
        root = new Node(values[0]);
        for(int i = 1; i < values.length; i++) {
            addElement(values[i]);
        }
    }

    @Override
    public int getRootElement()
    {
        return root.getValue();
    }

    @Override
    public int getNumberOfElements()
    {
        return count(root);
    }

    private int count(Node root){
        if(root == null){
            return 0;
        }
        return 1 + count(root.getLeft()) + count(root.getRight());
    }

    @Override
    public void addElement(int element)
    {
        add(root, element);
    }

    private void add(Node node, int element){
        if(element < node.getValue()){
            if(node.getLeft() == null){
                node.setLeft(new Node(element));
            }
            else{
               add(node.getLeft(),element);
            }
        }
        else if(element > node.getValue()){
            if(node.getRight() == null){
                node.setRight(new Node(element));
            }
            else{
                add(node.getRight(),element);
            }
        }
    }

    @Override
    public void addElements(int[] elements) {
        addMultiple(root, elements);
    }

    private void addMultiple(Node node, int[] elements){ 
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < node.getValue()) {
                if (node.getLeft() == null) {
                    node.setLeft(new Node(elements[i]));
                } else {
                    add(node.getLeft(), elements[i]);
                }
            } else if (elements[i] > node.getValue()) {
                if (node.getRight() == null) {
                    node.setRight(new Node(elements[i]));
                } else {
                    add(node.getRight(), elements[i]);
                }
            }
        }
    }

    @Override
    public boolean findElement(int value) {
        return found(root,value);
    }

    private boolean found(Node root, int value){
        boolean elementFound = false;

        if(root.getValue() == value) {
            elementFound = true;
        }

        else if(value > root.getValue()) {
            return found(root.getRight(),value);
        }
        else if (value < root.getValue()) {
            return found(root.getLeft(),value);
        }
        return elementFound;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        return retrieveLeftChild(root,element);
    }

    private int retrieveLeftChild(Node node, int element) throws ChildNotFoundException { // ??? exit // add another parameter called leftChildValue
        int leftChildValue = 0;

        if(node.getValue() == element){
            if (node.getLeft() == null){
                return 0;
            }else{
                leftChildValue = node.getLeft().getValue();
                return leftChildValue;
            }
        }

        else if(node.getLeft().getValue() > element || node.getLeft().getValue() == element){
            return retrieveLeftChild(node.getLeft(), element);
        }

        return leftChildValue;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        return retrieveRightChild(root,element);
    }

    private int retrieveRightChild(Node node, int element) throws ChildNotFoundException {
        int rightRightValue = 0;

        if (node.getValue() == element) {
            if (node.getRight() == null) {
                return 0;
            } else {
                rightRightValue = node.getRight().getValue();
                return rightRightValue;
            }
        } else if (node.getRight().getValue() > element || node.getRight().getValue() == element) {
            return retrieveLeftChild(node.getRight(), element);
        }

        return rightRightValue;
    }

    @Override
    public int[] getSortedTreeAsc() {
        return inorderTraverse(root);
    }

    private int[] inorderTraverse(Node node){
        if(node != null) {
            inorderTraverse(node.getLeft());
            arrayList.add(node.getValue());
            inorderTraverse(node.getRight());
        }
        return convertIntegers(arrayList);
    }

    @Override
    public int[] getSortedTreeDesc() {
        return inorderTraverseDesc(root);
    }

    private int[] inorderTraverseDesc(Node node){
        if(node != null) {
            inorderTraverseDesc(node.getRight());
            arrayList.add(node.getValue());
            inorderTraverseDesc(node.getLeft());
        }
        return convertIntegers(arrayList);
    }

    private int[] convertIntegers(List<Integer> arrayList) // arraylist to array
    {
        int[] convertedResult = new int[arrayList.size()];
        for (int i=0; i < convertedResult.length; i++)
        { 
            convertedResult[i] = arrayList.get(i).intValue();
        }
        return convertedResult;
    }
    
}

