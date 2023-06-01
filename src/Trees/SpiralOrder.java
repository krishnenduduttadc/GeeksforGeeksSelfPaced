/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author krish
 */
public class SpiralOrder {

    static Node root;

    static class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    private static void spiralOrder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        Stack<Integer> s = new Stack<Integer>();
        boolean reverse = false;
        q.add(root);
        while (q.isEmpty() == false) {
            int cnt = q.size();
            for (int i = 0; i < cnt; i++) {
                Node temp = q.poll();
                if (reverse == true) {
                    s.push(temp.key);
                } else {
                    System.out.print(temp.key + " ");
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            if (reverse) {
                while (s.isEmpty() == false) {
                    System.out.print(s.pop() + " ");
                }
            }
            reverse = !reverse;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        spiralOrder(root);
    }
}
