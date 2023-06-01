/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

/**
 *
 * @author krish
 */
public class PrintNodesatDistK {

    static Node root;

    static class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static void printNodesatDistK(Node root, int k) {
        if (root == null) {
            return;
        }
        if(k==0){
            System.out.print(root.key+" ");
        }else{
            printNodesatDistK(root.left,k-1);
            printNodesatDistK(root.right,k-1);
        }
    }

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        //root.right.right.right = new Node(50);
        
        printNodesatDistK(root,2);
    }

}
