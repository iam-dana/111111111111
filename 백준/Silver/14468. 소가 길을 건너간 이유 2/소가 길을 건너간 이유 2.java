import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.next().split("");
        int[][] alp = new int[26][2];
        int answer = 0;

        for (int i=0; i<52; i++) {
            String s = input[i];
            char c = s.charAt(0);
            if (alp[c-'A'][0] == 0) {
                alp[c-'A'][0] = i+1;
            } else {
                alp[c-'A'][1] = i+1;
            }
        }
        for (int i=0; i<26; i++) {
            int s1 = alp[i][0];
            int e1 = alp[i][1];
            for (int j=0; j<26; j++) {
                int s2 = alp[j][0];
                int e2 = alp[j][1];
                if (s1 < s2 && s2 < e1 && e1 < e2) {
//                    System.out.println((char)(i+'A')+" "+(char)(j+'A'));
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
