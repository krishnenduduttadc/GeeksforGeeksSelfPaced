/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaPrac;


public class Das extends Danti{
    
    Das(int a,int b,int c){
       x=a;
       y=b;
       z=c;
    }
    public static void main(String[] args) {
        Das objdas=new Das(5,4,6);
        System.out.println(objdas.cubeSum());
        System.out.println(objdas.cubeVol());
    }
}
