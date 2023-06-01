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
public class T {

    public static void main(String[] args) {
        String a = "1234";
        System.out.println(addStars("abccdd"));
        
        //System.out.println(a.charAt(1)-'0');
    }
    
    public static String addStars(String s) {
		if(s.length()==1) {
			return s;
		}
                String small=addStars(s.substring(1));
                if(s.charAt(0)==s.charAt(1)){
                    return s.charAt(0)+"*"+small;
                }
                    return s.charAt(0) + small;
                

	}

    

    
}
