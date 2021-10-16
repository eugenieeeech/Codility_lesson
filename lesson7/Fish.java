//https://app.codility.com/demo/results/trainingNHPEBU-FYS/
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        Stack<Integer>  s = new <Integer>Stack(); //storage the downstream fish 
        int alive = A.length;//count hw many fish it is eaten 
        if (alive ==0) return 0;
        for(int i=0;i<A.length;i++){
            if(B[i] == 1){
                s.push(new Integer(A[i]));
            }else {
               while ((!s.isEmpty())){
                  if(s.peek() > A[i]){
                      alive--;
                      break;
                      }
                  if(s.peek() < A[i]){
                      s.pop();
                      alive--; //another downstream fish can eat now
                      }   
                }
            }
        }
        return alive;
    }
}

