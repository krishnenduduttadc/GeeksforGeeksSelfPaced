/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author krish
 */
public class StackwithQueue {

    static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();
    static int curr_size;

    StackwithQueue() {
        curr_size = 0;
    }

    static int top() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.peek();
    }

    static int size() {
        return curr_size;
    }

    static void push(int x) {
        curr_size++;
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }
        while (!q2.isEmpty()) {
            q1.add(q2.peek());
            q2.remove();
        }
    }

    public static void main(String[] args) {
        StackwithQueue s = new StackwithQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.push(4);
        System.out.println("current size: " + s.size());
        System.out.println(s.top());
    }
}
