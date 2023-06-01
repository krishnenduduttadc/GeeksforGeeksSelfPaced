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
public class ChildrenSum {

    static Node root;

    static class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static boolean childernsum(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int sum = 0;
        if (root.left != null) {
            sum = sum + root.left.key;
        }
        if (root.right != null) {
            sum = sum + root.right.key;
        }

        if (root.key == sum && childernsum(root.left) && childernsum(root.right)) {
            return true;
        } else {
            return false;
        }
    }

    static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (q.isEmpty() == false) {

            Node curr = q.poll();
            System.out.print(curr.key + " ");

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    static Node LCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.key == n1 || root.key == n2) {
            return root;
        }
        Node lca1 = LCA(root.left, n1, n2);
        Node lca2 = LCA(root.right, n1, n2);
        if (lca1 != null && lca2 != null) {
            return root;
        }
        if (lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }

    }

    public static void main(String[] args) {
        root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        //root.right.right.right = new Node(50);

        System.out.println("Children sum property: " + childernsum(root));
        levelOrder(root);
        
        System.out.println("LCA is: " + LCA(root,12,3).key);
    }
}
