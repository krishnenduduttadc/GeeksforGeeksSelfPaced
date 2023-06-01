/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author krish
 */
public class Permutation {

    public static void main(String[] args) {
       ArrayList<String> p= FindPermutations("aabb");
        for (Iterator<String> iterator = p.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            System.out.println(""+next);
        }
    }

    
    public static ArrayList<String> FindPermutations(String STR) {
        //ArrayList<String> as=new ArrayList<>();
        return permute(STR, 0, STR.length()-1,  new ArrayList<>());

    }
    
    static ArrayList<String> permute(String str, int l, int r, ArrayList<String> as) {
        if (l == r) {
            //System.out.println(str);
            as.add(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r,as);
                str = swap(str, l, i);
            }
        }
        return as;
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
