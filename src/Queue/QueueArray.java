/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import java.util.Stack;

/**
 *
 * @author krish
 */
public class QueueArray {

    private static int front, rear, capacity, size;
    private static int arr[];

    QueueArray(int c) {
        front = rear = 0;
        size = 0;
        capacity = c;
        arr = new int[capacity];
    }

    static void queueDisplay() {
        int i;
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }

        // traverse front to rear and print elements 
        for (i = front; i < rear; i++) {
            System.out.printf(" %d -- ", arr[i]);
        }
        return;
    }

    static boolean isFull() {
        return (size == capacity);
    }

    static boolean isEmpty() {
        return (size == 0);
    }

    void enqueue(int x) {
        if (isFull() == true) {
            return;
        }
        arr[rear] = x;
        rear++;
    }

    void dequeue() {
        if (isEmpty() == true) {
            return;
        }
        for (int i = 0; i < rear - 1; i++) {
            arr[i] = arr[i + 1];

        }
        rear--;
    }



    public static void main(String[] args) {
        QueueArray q = new QueueArray(4);
        q.queueDisplay();
        q.enqueue(11);
        q.enqueue(22);
        q.enqueue(33);
        q.enqueue(44);
        q.dequeue();
        q.queueDisplay();

    }
}
