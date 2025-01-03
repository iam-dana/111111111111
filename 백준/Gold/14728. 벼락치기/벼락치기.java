import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] p = new int[N+1][2];
        int[][] dp = new int[N+1][T+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=N; i++) {
            int K = p[i][0];
            int S = p[i][1];

            for (int j=1; j<=T; j++) {
                if (K > j) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-K]+S);
            }
        }
        bw.write(String.valueOf(dp[N][T]));
        bw.close();
    }
}
