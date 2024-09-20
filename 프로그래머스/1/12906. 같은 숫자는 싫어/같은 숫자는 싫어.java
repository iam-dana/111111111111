import java.util.*;

public class Solution {
    public List solution(int []arr) {
        ArrayList<Integer> answer =  new ArrayList<>();

        for (int a : arr) {
            if (answer.size() == 0) {
                answer.add(a);
                continue;
            }
            if (answer.get(answer.size()-1) == a) continue;
            answer.add(a);
        }
        
        return answer;
    }
}