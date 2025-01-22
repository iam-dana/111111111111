import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] subject = new int[K+1][2];
        int[][] dp = new int[K+1][N+1];

        for (int i=1; i<=K; i++) {
            st = new StringTokenizer(br.readLine());
            subject[i][0] = Integer.parseInt(st.nextToken());
            subject[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=K; i++) {
            int I = subject[i][0];
            int T = subject[i][1];
            for (int j=1; j<=N; j++) {
                if (j < T) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-T]+I);
            }
        }
        bw.write(String.valueOf(dp[K][N]));
        bw.close();
    }
}
