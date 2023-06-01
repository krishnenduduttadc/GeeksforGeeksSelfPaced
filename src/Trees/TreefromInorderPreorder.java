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
public class TreefromInorderPreorder {

    Node root;
    static int preIndex = 0;

    static class Node {

        char data;
        Node left, right;

        Node(char item) {
            data = item;
            left = right = null;
        }
    }

    int search(char arr[], int strt, int end, char value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return i;
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    Node buildTree(char in[], char pre[], int inStrt, int inEnd) {
        if (inStrt > inEnd) {
            return null;
        }
        Node tNode = new Node(pre[preIndex++]);
        if (inStrt == inEnd) {
            return tNode;
        }
        int inIndex = search(in, inStrt, inEnd, tNode.data);
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    public static void main(String args[]) {
        TreefromInorderPreorder tree = new TreefromInorderPreorder();
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal 
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}
