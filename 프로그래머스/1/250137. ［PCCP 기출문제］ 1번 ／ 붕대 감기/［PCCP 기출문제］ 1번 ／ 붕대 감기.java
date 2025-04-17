import java.io.*;
import java.util.*;

class Solution {
    // bandage [시전시간, 초당회복량, 추가회복량]
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int[] game = new int[1001];
        
        int now = health;
        int end = 0;
        
        for (int[] x: attacks) {
            game[x[0]] = x[1];
            end = x[0];
        }
  
        int count = 1;
        
        for (int i=1; i<=end; i++) {
            System.out.println(now);
            count += 1;
            if (game[i] == 0) {  // 몬스터 공격 없을 때
                if (count < bandage[0]) { // 추가회복 X
                    if (now+bandage[1] < health) {
                        now += bandage[1];
                    } else {
                        now = health;
                    }
                    // count += 1;
                } else if (count == bandage[0]) { // 추가회복 O
                    if (now+bandage[1]+bandage[2] < health) {
                        now += bandage[1]+bandage[2];
                    } else {
                        now = health;
                    }
                    count = 0;
                } 
            } else {  // 몬스터 공격 있을 때
                count = 0;
                now -= game[i];
                if (now <= 0)  {
                    now = -1;
                    break;
                }
                // count = 1;
            }
        }
        
        
        return now;
    }
}