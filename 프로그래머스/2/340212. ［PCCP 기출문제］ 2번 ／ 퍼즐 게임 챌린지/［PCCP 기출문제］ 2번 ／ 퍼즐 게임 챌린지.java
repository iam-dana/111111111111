import java.io.*;
import java.util.*;

class Solution {
    static int N; 

    public int solution(int[] diffs, int[] times, long limit) {
        N = diffs.length;
        int answer = Integer.MAX_VALUE;
    
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        // System.out.println(solve(39354, diffs, times));
        
        while (left <= right) {
            int mid = (left+right)/2;
            long tmp = solve(mid, diffs, times);
            if (tmp > limit) {
                left = mid+1;
            } else {
                answer = Math.min(answer, mid);
                right = mid-1;
            }
        }
        
        return answer;
    }
    
    public long solve(int level, int[] diffs, int[] times) {
        long tmp = 0;
        for (int i=0; i<N; i++) {
           int diff = diffs[i];
           int time = times[i];
           if (level < diff) {     
               if (i == 0) {
                   tmp += time*(diff-level);
               } else { // (지금 문제 걸리는 시간 + 이전 문제 시간)*틀리는 횟수 + 지금 문제 걸리는 시간
                   tmp += (time+times[i-1])*(diff-level)+time;
               }
           } else {
               tmp += time;
           }
        }
        return tmp;
    }
}