// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
// Using set : unique and not repeating
class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int i=0;
        Set<Integer> set = new HashSet<Integer>();
        for (i=0;i<A.length;i++){
            set.add(A[i]);
            if (set.size() == X){
                return i;
            }
        }
        return -1;
    }
}