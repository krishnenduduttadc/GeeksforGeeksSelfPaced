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
public class TreeHelperFn {

    static Node root;

    static class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    static int maximum(Node root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(root.key, Math.max(maximum(root.left), maximum(root.right)));
        }
    }

    static int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return size(root.left) + size(root.right) + 1;
        }
    }

    static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh - rh) <= 1 && root.left != null && root.right != null) {
            return true;
        } else {
            return false;
        }
    }

    static int maxWidth(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()) {
            int cnt = q.size();
            //System.out.println(cnt);
            res = Math.max(cnt, res);
            for (int i = 0; i < cnt; i++) {
                Node tmp = q.poll();
                if (tmp.left != null) {
                    q.add(tmp.left);
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
        }
        return res;
    }
    static int res = 0;

    static int diameter(Node root) {
        if (root == null) {
            return 0;
        } else {
            int lh = diameter(root.left);
            int rh = diameter(root.right);
            res = Math.max(res, lh + rh + 1);
            return 1 + Math.max(lh, rh);
        }
    }

    static Node prev = null;

    static Node BinTree2LL(Node root) {
        if (root == null) {
            return root;
        }
        Node head = BinTree2LL(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        BinTree2LL(root.right);
        return head;
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
        root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        //root.right.right.right = new Node(50);
        System.out.println("Height of tree is: " + height(root));
        System.out.println("Maximum of tree is: " + maximum(root));
        System.out.println("Size of tree is: " + size(root));
        System.out.println("Balanced: " + isBalanced(root));
        System.out.println("Maximum width is: " + maxWidth(root));
        System.out.println("Diameter  is: " + diameter(root));
        System.out.println("LCA of 40 and 50  is: " + LCA(root, 40, 50).key);
    }
}
