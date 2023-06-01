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
public class MyTree {

    static Node root;

    static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node p = q.poll();
            System.out.print(" " + p.key);
            if (p.left != null) {
                q.add(p.left);
            }
            if (p.right != null) {
                q.add(p.right);
            }
        }
    }

    static void levelOrderlinebyline(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node p = q.poll();
                System.out.print(p.key + " ");
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            }
            System.out.println("");
        }
    }

    public static void leftView(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            int cnt = q.size();
            for (int i = 0; i < cnt; i++) {
                Node p = q.poll();
                if (i == 0) {
                    System.out.print(p.key + " ");
                }
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            }
            System.out.println("");
        }
    }

    static void maxWidth(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        int c = 0;
        while (!q.isEmpty()) {
            int cnt = q.size();
            c = Math.max(cnt, c);
            for (int i = 0; i < cnt; i++) {
                Node p = q.poll();
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            }
        }
        System.out.print(c + " ");
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    static void inorderIter(Node root) {

        Stack<Node> s = new Stack<Node>();
        Node curr = root;
        while (curr != null || !s.empty()) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.pop();
                System.out.print(curr.key + " ");
                curr = curr.right;
            }
        }
    }

    static void preorderIter(Node root) {
        if(root==null)return;
        Stack<Node> s = new Stack<Node>();
        s.push(root);

        while (!s.isEmpty()) {
            Node curr = s.pop();
            System.out.print(curr.key + " ");
            if (curr.right != null) {
                s.push(curr.right);
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
        }
    }

    static int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + size(root.left) + size(root.right);
        }
    }

    static int max(Node root) {
        if (root == null) {
            return -1;
        } else {
            return Math.max(root.key, Math.max(max(root.left), max(root.right)));
        }
    }

    static int isBalanced(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = isBalanced(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = isBalanced(root.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        } else {
            return (Math.max(lh, rh) + 1);
        }
    }

    static int sumTree(Node root) {
        int sum = 0;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node p = q.poll();
            sum = sum + p.key;
            if (p.left != null) {
                q.add(p.left);
            }
            if (p.right != null) {
                q.add(p.right);
            }
        }
        return sum;
    }

    static boolean isChildrenSum(Node root) {
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
        return root.key == sum && isChildrenSum(root.left) && isChildrenSum(root.right);
    }

    public static void printKdist(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.key + " ");
        }
        printKdist(root.left, k - 1);
        printKdist(root.right, k - 1);
    }

    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        levelOrder(root);
        System.out.println("\n--------------");
        inorder(root);
        System.out.println("\n--------------");
        inorderIter(root);
        System.out.println("\n--------------");
        preorderIter(root);
        System.out.println("\n--------------");
        levelOrderlinebyline(root);
        System.out.println("size is: " + size(root));
        System.out.println("sum is: " + sumTree(root));
        System.out.println("maximum is: " + max(root));
        leftView(root);
        System.out.println(isBalanced(root) + "is balanced ");
        maxWidth(root);

        System.out.println(isChildrenSum(root) + "");
        printKdist(root, 2);
    }
}
