import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t=0; t<3; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] coins = new int[N][2];
            int[] dp = new int[100001];
            int total = 0;
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                coins[i][0] = Integer.parseInt(st.nextToken());
                coins[i][1] = Integer.parseInt(st.nextToken());
                total += coins[i][0]*coins[i][1];
            }

            if (total % 2 == 1) {
                System.out.println(0);
                continue;
            }

            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i=0; i<N; i++) {
                int coin = coins[i][0];
                int num = coins[i][1];
                for (int j=0; j<=total/2; j++) {
                    if (dp[j] == Integer.MAX_VALUE) continue;
                    if (j+coin <= total/2 && dp[j] < num) {
                        dp[j+coin] = Math.min(dp[j+coin], dp[j]+1);
                    }
                    dp[j] = 0;
                }
            }
            if (dp[total/2] != Integer.MAX_VALUE) System.out.println(1);
            else System.out.println(0);
        }
    }
}
