/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author krish
 */
class QNode {

    int data;
    QNode next;

    QNode(int x) {
        data = x;
        next = null;
    }
}

public class QueueLL {

    QNode front, rear;
    int size;

    QueueLL() {
        front = rear = null;
        size=0;
    }

    void enque(int x) {
        QNode temp = new QNode(x);
        size++;
        if (front == null) {
            front = rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
        
    }

    void deque() {
        if (front == null) {
            return;
        }
        front=front.next;
        size--;
        if(front==null){
            rear=null;
        }
    }

    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        q.enque(10);
        q.enque(20);
        q.enque(30);
        q.enque(40);
        q.enque(50);
        q.deque();
        System.out.printf("Size is "+q.size);
    }
}
