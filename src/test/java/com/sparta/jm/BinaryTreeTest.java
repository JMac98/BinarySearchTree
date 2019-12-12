package com.sparta.jm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.sparta.jm.controller.BinarySearchTree;
import com.sparta.jm.exceptions.ChildNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BinaryTreeTest
{
    private BinarySearchTree binarySearchTree;

    @Before
    public void setup(){
        binarySearchTree = new BinarySearchTree(new int[] {10,4,5,2,18,20});
    }

    @Test
    public void getRootElementTest()
    {
        int rootElement = binarySearchTree.getRootElement();

        assertEquals(rootElement, 10);
    }

    @Test
    public void getNumberOfElementsTest()
    {
        int numberOfElements1 = binarySearchTree.getNumberOfElements();

        assertEquals(6, numberOfElements1);
    }

    @Test
    public void addElementTest() {
        BinarySearchTree binarySearchTree2 = new BinarySearchTree(new int[] {20,50});
        binarySearchTree2.addElement(60);
        int elementsAdded = binarySearchTree2.getNumberOfElements();

        assertEquals(3, elementsAdded);
    }

    @Test
    public void findElement() {
        binarySearchTree.addElements(new int[]{20,50,30,24});
        assertEquals(true, binarySearchTree.findElement(30));
    }

    @Test
    public void addElementsTest() {
        BinarySearchTree binarySearchTree2 = new BinarySearchTree(new int[] {20,50});
        binarySearchTree2.addElements(new int[]{60,70});
        int elementsAdded = binarySearchTree2.getNumberOfElements();

        assertEquals(4, elementsAdded);
    }

    @Test
    public void findElementTest() {
        boolean elementFound = binarySearchTree.findElement(20);

        assertEquals(true, elementFound);
    }

    @Test
    public void getLeftChildTest() throws ChildNotFoundException { //needs an exit condition

        assertEquals(binarySearchTree.getLeftChild(2),0);
    }

    @Test
    public void getRightChildTest() throws ChildNotFoundException {
        assertEquals(binarySearchTree.getRightChild(10),18);
    }

    @Test
    public void getTreeAsc() throws ChildNotFoundException {
        int[] expectedResult = new int[]{2,4,5,10,18,20};

        int[] sortedTree = binarySearchTree.getSortedTreeAsc();

        assertEquals(Arrays.toString(expectedResult),Arrays.toString(sortedTree));
    }

    @Test
    public void getTreeDec() throws ChildNotFoundException {
        int[] expectedResult = new int[]{20,18,10,5,4,2};

        int[] sortedTree = binarySearchTree.getSortedTreeDesc();

        assertEquals(Arrays.toString(expectedResult),Arrays.toString(sortedTree));
    }

}
