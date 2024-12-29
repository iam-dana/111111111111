import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L, K;   // N: 가로길이, M: 세로길이, L: 트램펄린 한 변의 길이, K: 별똥별의 수
    static int x, y, tmp, ans=Integer.MAX_VALUE;
    static List<int[]> stars;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new ArrayList<>();
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }

        for (int[] star1 : stars) {
            x = star1[0];
            for (int[] star2 : stars) {
                y = star2[1];
                tmp = 0;
                for (int[] star3 : stars) {
                    if (x > star3[0] || star3[0] > x+L || y > star3[1] || star3[1] > y+L) tmp++;
                }
                ans = Math.min(ans, tmp);
            }
        }
        System.out.println(ans);
    }
}
