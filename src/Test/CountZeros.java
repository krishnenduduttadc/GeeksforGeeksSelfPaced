/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author krish
 */
public class CountZeros {

    public static void main(String[] args) {
        System.out.println(countZerosRec(10320));
    }

    static int cnt=0;
    public static int countZerosRec(int input) {
        // Write your code here
        if (input == 0) {
            return 1;
        }      
        if (input % 10 == 0) {
            cnt++;           
        }
        countZerosRec(input / 10);                  
        return  cnt;
    }
}
