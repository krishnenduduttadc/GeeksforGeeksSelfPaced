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
public class ASCIITest {

    public static void main(String[] args) {

//        String p="amit";
//        int q='1'-'0';// character 3 to integer 3
//        System.out.println(q); 
//        q=q+'a'-1;//integer 3 to char c        
//        System.out.println((char)q);
//        String s = "123456789";
//        for (int i = 0; i < s.length(); i++) {
//            char n = table(s.charAt(i));
//            System.out.println( s.charAt(i)+ " " + n);
//        }
        String inp = "1123";
        //System.out.println(getCode(inp));

        String[] l = getCode(inp);
        for (int i = 0; i < l.length; i++) {
            System.out.println(l[i]);
        }
    }

    static String[] getCode(String input) {

        if (input.length() == 0) {
            String[] ap = new String[1];
            ap[0] = "";
            return ap;
        }

        String[] ans = getCode(input.substring(1));
        char c = table(input.charAt(0));
        String[] res = new String[ans.length];

        for (int i = 0; i < ans.length; i++) {
            res[i] = c + ans[i];
        }

//        if(input.length()>=2){
//        	String[] ssans=getCode(input.substring(2));
//            int l=96+(Integer.parseInt(input.substring(0,2)));
//            if(l>=97 && l<=122){
//                char cc=(char)(l);
//                String s=String.valueOf(cc);
//                String[] arr=new String[ans.length+ssans.length];
//                int i,k=0;
//                for(i=0; i<ans.length; i++){
//                    arr[i]=s+ans[i];
//                    k++;
//                }
//                for(i=0; i<ssans.length; i++){
//                    arr[k]=s+ssans[i];
//                    k++;
//                }
//                //System.out.println("2 "+Arrays.toString(arr));
//                return arr;
//            }
//        }
        return res;
    }

    static char table(char input_char) {
        int input_int = input_char - '0';
        input_int = input_int + 'a' - 1;
        return (char) input_int;
    }
}
