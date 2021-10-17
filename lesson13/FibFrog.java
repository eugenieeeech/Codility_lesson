

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    //BFS method
    public class Jump {
        int pos;
        int move;
        public Jump(int pos, int move) {
            this.pos = pos;
            this.move = move;
        }
    }
    private List <Integer> fibArr(int n) {
        //find the Fibonacci sequence the the frog can jump with N
        List <Integer> fibs = new ArrayList <> ();
        fibs.add(1);
        fibs.add(1);
        while (fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2) <= n) {
            fibs.add(fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2));
        }
        return fibs;
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
       
        List <Integer> fibJmp = fibArr(N); 
        //BFS init
        Queue <Jump> pos = new LinkedList <Jump> ();
        boolean[] visited = new boolean[N];
        
        if (N<=2){ 
            return 1;
        }

        for (int i = 0; i < fibJmp.size(); i++) {
            int initPos = fibJmp.get(i) - 1;
            if (A[initPos] == 0)
                continue;
            pos.add(new Jump(initPos, 1));
            visited[initPos] = true;
        }

        while (!pos.isEmpty()) {  //have node
            Jump jump = pos.remove();
            for (int j = fibJmp.size() - 1; j >= 0; j--) {
                int nextPos = jump.pos + fibJmp.get(j); //greedy attempt
                if (nextPos == N)
                    return jump.move + 1; //min result of BFS
                else if (nextPos < N && A[nextPos] == 1 && !visited[nextPos]) {
                    pos.add(new Jump(nextPos, jump.move + 1));
                    visited[nextPos] = true;
                }
            }
        }
        
        return -1;
    }

}

