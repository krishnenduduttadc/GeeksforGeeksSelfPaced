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
class Node1 {

    int data;
    Node1 next;

    Node1(int d) {
        this.data = d;
    }

}

public class SinglyLL {

    Node1 head;

    void insertAtBeg(int x) {
        Node1 temp = new Node1(x);
        temp.next = head;
        head = temp;

    }

    void insertEnd(int x) {
        Node1 temp = new Node1(x);
        if (head == null) {
            head = temp;
            return;
        }
        Node1 curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
    }

    void printList() {
        Node1 curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
    void middleNode(){
        Node1 fast=head,slow=head;
        if(head==null){
            return;
        }
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        System.out.println("\n"+slow.data + " is middle node");
    }
    
    void printNthfromEnd(int n){
        int len=0;
        for(Node1 curr=head;curr!=null;curr=curr.next){
            len++;
        }
        System.out.println(len);
        if(len<n)return;
        Node1 curr=head;
        for(int i=0;i<len-n;i++){
            curr=curr.next;
        }
        System.out.println("\n"+curr.data + " is "+n+"th node");
    }
    
    void reverse(){
        Node1 curr=head;
        Node1 prev=null;
        while(curr!=null){
            Node1 next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
    }
    boolean detectLoop(){
        Node1 fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }return false;
    }
    void detectandRemoveLoop(){
        Node1 fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(slow!=fast){
            return;
        }
        slow=head;
        while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
    }
    void deleteNodeOnePtr(Node1 ptr){
        Node1 tmp=ptr.next;
        ptr.data=tmp.next.data;
        ptr.next=tmp.next.next;
    }

    public static void main(String[] args) {
        SinglyLL b = new SinglyLL();
        b.insertAtBeg(10);
        b.insertAtBeg(20);
        b.insertAtBeg(30);
        b.insertEnd(40);

        b.printList();
        b.insertEnd(50);
        System.out.println();
        b.printList();
        b.middleNode();    
        b.printNthfromEnd(3);
        
        b.reverse();
        b.printList();
        System.out.println("Loop is present: "+b.detectLoop());
    }
}
