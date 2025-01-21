import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        st = new StringTokenizer(br.readLine());
        int[] coffee = new int[N+1];
        for (int i=1; i<=N; i++) coffee[i] = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            int now = coffee[i];
            for (int j=K; j>=0; j--) {
                if (j-now >= 0 && dp[j-now] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], dp[j-now]+1);
            }
        }
        bw.write(String.valueOf(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]));
        bw.close();
    }
}
