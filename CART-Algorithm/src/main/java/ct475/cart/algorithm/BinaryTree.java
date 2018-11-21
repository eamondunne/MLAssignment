/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct475.cart.algorithm;

/**
 *
 * @author Cormac Buckley
 */
public class BinaryTree {

    Node root;

    public BinaryTree buildTree() {
        BinaryTree bt = new BinaryTree();

        
        bt.add(10);
        bt.add(2);
        bt.add(7);
        bt.add(13);
        bt.add(1);
        bt.add(3);
        bt.add(4);

        return bt;
    }

    public Node insertRecursive(Node currentNode, int newNode) {
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

    public void add(int newNode) {
        root = insertRecursive(root, newNode);
    }

    
    public boolean checkForNode(Node currentNode, int targetNode){
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
    
    public boolean containsNode(int value) {
    return checkForNode(root, value);
}
    
    
}
