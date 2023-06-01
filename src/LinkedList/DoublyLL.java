/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author krish
 */
class Node2 {

    int data;
    Node2 next;
    Node2 prev;

    Node2(int d) {
        this.data = d;
    }

}

public class DoublyLL {

    Node2 head;

    void insertAtBeg(int x) {
        Node2 temp = new Node2(x);
        temp.next = head;
        temp.prev = null;
        head = temp;

    }

    void printList() {
        Node2 curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        DoublyLL b = new DoublyLL();
        b.insertAtBeg(10);
        b.insertAtBeg(20);
        b.insertAtBeg(30);
        b.printList();
    }
}
