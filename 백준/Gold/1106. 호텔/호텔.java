import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[C+101];
        Arrays.fill(dp, Integer.MAX_VALUE-(1000)*N);
        dp[0] = 0;

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            for (int j=customer; j<=C+100; j++) {
                dp[j] = Math.min(dp[j-customer]+cost, dp[j]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i=C; i<=C+100; i++) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
