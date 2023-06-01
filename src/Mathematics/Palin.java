/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mathematics;

/**
 *
 * @author krish
 */
public class Palin {
    public static void main(String[] args) {
        int a=125455,v=0;
        int rev=0;
        while(a!=0){
            int u=a%10;
            rev=rev*10+u;
            a=a/10;
            
        }
        System.out.println(""+rev);
    }
    
}
