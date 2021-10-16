// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int result = 0, temp = 0;
        String str =Integer.toBinaryString(N);
        char[] ch = str.toCharArray();
        Boolean counter = false;
        
        for (int i = ch.length-1; i>=0;i--){
            if(ch[i] == '1'){
                counter = true;
                
                if (temp > result){
                    result = temp;
                }
                temp=0;
                
            }else if (counter==true){
                temp++;
            }
        }

        return result;
    }
}