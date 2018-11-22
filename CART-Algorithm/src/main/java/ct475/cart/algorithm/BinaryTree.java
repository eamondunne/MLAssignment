/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct475.cart.algorithm;

import java.util.ArrayList;

/**
 *
 * @author Cormac Buckley
 */
public class BinaryTree {

    Node root;

    public BinaryTree buildTree(ArrayList<Double> data) {
        BinaryTree bt = new BinaryTree();
        
        for(double i: data){
            bt.add(i);
        }

        return bt;
    }

    public Node insertRecursive(Node currentNode, double newNode) {
        if (currentNode == null) {
            return new Node(newNode);
        }
        if (newNode < currentNode.value) {
            currentNode.left = insertRecursive(currentNode.left, newNode);
        } else if (newNode > currentNode.value) {
            currentNode.right = insertRecursive(currentNode.right, newNode);
        } else {
            return currentNode;
        }
        return currentNode;
    }

    public void add(double newNode) {
        root = insertRecursive(root, newNode);
    }

    
    public boolean checkForNode(Node currentNode, double targetNode){
        boolean result = false;
        if(currentNode == null){
            result = false;
        }
        if (currentNode.value == targetNode){
            result =  true;
        }
        if (currentNode.value < targetNode){
            return checkForNode(currentNode.right, targetNode);
        }
        else if(currentNode.value > targetNode){
            return checkForNode(currentNode.left, targetNode);
        }
        return result;
    }
    
    public boolean containsNode(double value) {
    return checkForNode(root, value);
}
    
    
}
