import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sum = new int[N+1];
        dp = new int[N+1][M+1];
        Arrays.fill(dp[0], -32768*101);
        dp[0][0] = 0;

        for (int i=1; i<=N; i++) {
            sum[i] = sum[i-1]+Integer.parseInt(br.readLine());
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                dp[i][j] = dp[i-1][j];
                for (int k=i; k>0; k--) {
                    if (k >= 2) dp[i][j] = Math.max(dp[i][j], dp[k-2][j-1]+sum[i]-sum[k-1]);
                    else if (k == 1 && j == 1) {
                        dp[i][j] = Math.max(dp[i][j], sum[i]);
                    }
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
