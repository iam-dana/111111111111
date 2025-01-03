import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N + 1];
            int[][] dp = new int[N + 1][10001];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
                dp[i][coins[i]]++;
            }

            int M = Integer.parseInt(br.readLine());


            for (int i = 1; i <= N; i++) {
                int coin = coins[i];
                for (int j=1; j<=M; j++) {
                    if (coin > j) {
                        dp[i][j] = dp[i-1][j];
                        continue;
                    }
                    dp[i][j] += dp[i-1][j] + dp[i][j-coin];
                }
            }
            sb.append(dp[N][M]).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();
    }
}
