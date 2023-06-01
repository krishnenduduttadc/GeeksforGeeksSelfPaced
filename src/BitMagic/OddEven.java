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
public class OddEven {
    public static void main(String[] args) {
        int p=10;
        p=p&1;
        if(p==0){
            System.out.println("even");
        }
        else{
            System.out.println("odd");
        }
    }
    
}
