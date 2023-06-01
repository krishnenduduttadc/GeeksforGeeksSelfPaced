/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author krish
 */
public class ReverseQueue {

    //static Queue<Integer> q;
    static void queueRevI(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.peek());
            q.remove();
        }
        while (!s.isEmpty()) {
            q.add(s.peek());
            s.pop();
        }
    }

    static void print(Queue<Integer> q) {
        while (!q.isEmpty()) {
            System.out.print(q.peek() + "->");
            q.remove();
        }
    }

    static void queueRevR(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int x = q.peek();
        q.poll();
        queueRevR(q);
        q.add(x);

    }

    static void myrevQueueI(Queue<Integer> q) {
        Stack<Integer> s = new Stack<Integer>();
        while (!q.isEmpty()) {
            s.add(q.poll());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        print(q);
    }
    
    static void myrevQueueR(Queue<Integer> q){
        if(q.isEmpty()){
            return;
        }
        int x=q.poll();       
        myrevQueueR(q);
        q.add(x);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        //print(q);
        //queueRevR(q);
        myrevQueueR(q);
        print(q);
    }
}
