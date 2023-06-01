/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author krish
 */
public class LeftView {

    static Node root;
    static int maxlevel = 0;

    static class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    private static void leftViewRec(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxlevel < level) {
            System.out.print(root.key + " ");
            maxlevel = level;
        }
        leftViewRec(root.left, level + 1);
        leftViewRec(root.right, level + 1);
    }

    private static void leftViewIter(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (q.isEmpty() == false) {
            int cnt = q.size();
            for (int i = 0; i < cnt; i++) {
                Node temp = q.poll();
                if (i == 0) {
                    System.out.print(temp.key + " ");
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

        }
    }

    public static boolean find(Node node, int data) {
        // write your code here
        if(node==null){
            return false;
        }
        if (node.key == data) {
            return true;
        } else {
            boolean l = find(node.left, data);
            boolean r = find(node.right, data);
            return l || r;
        }
    }

    

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        //root.right.right.right = new Node(50);
        leftViewRec(root, 2);
        System.out.println();
        leftViewIter(root);
        
        System.out.println("found: "+find(root,10));

    }
}
