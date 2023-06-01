/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BitMagic;

/**
 *
 * @author krish
 */
public class Swap {
    public static void main(String[] args) {
        int a=5;
        int b=10;
        a=a^b;
        b=a^b;
        a=a^b;
        
        System.out.println("after swap: "+a+" "+b);
    }
 
}
