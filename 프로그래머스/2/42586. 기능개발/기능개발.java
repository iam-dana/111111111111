import java.util.*;

class Solution {
    public List solution(int[] p, int[] s) {
        List<Integer> answer = new ArrayList<>();
        int[] tmp = new int[p.length];
        
        for (int i=0; i<p.length; i++) {
            tmp[i] = (int)Math.ceil((double)(100-p[i])/s[i]);
        }
        
        int now = tmp[0];
        int num = 1;
        
        // System.out.println(Arrays.toString(tmp));
        
        if (p.length==1) answer.add(num);
        else {
            for (int i=1; i<p.length; i++) {
                if (tmp[i] <= now) {
                    num += 1;
                } else {
                    answer.add(num);
                    num = 1;
                    now = tmp[i];
                }
            }
            answer.add(num);
        }
        return answer;
    }
}