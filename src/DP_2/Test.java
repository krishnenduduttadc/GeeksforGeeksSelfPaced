/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP_2;

/**
 *
 * @author krish
 */
public class Test {

    public static void main(String[] args) {
        String xx = "ABCD";
        System.out.println(pow("xaxb"));
    }

    static int c = 0;

    public static String pow(String str) {

        if (str.length()==0) {
            return str;
        } else {
            if(str.charAt(0)=='x'){
                return pow(str.substring(1));
            }
        }
        return str.charAt(0)+pow(str.substring(1));
    }
}
