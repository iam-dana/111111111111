import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] temp1, temp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = map[0][0];
        for (int i=1; i<M; i++) {
            dp[0][i] = map[0][i] + dp[0][i-1];
        }

        for (int i=1; i<N; i++) {
            temp1 = new int[M];
            temp2 = new int[M];

            temp1[0] = dp[i-1][0] + map[i][0];
            for (int j=1; j<M; j++) {
                temp1[j] = Math.max(temp1[j-1]+map[i][j], dp[i-1][j]+map[i][j]);
            }

            temp2[M-1] = dp[i-1][M-1] + map[i][M-1];
            for (int j=M-2; j>=0; j--) {
                temp2[j] = Math.max(temp2[j+1]+map[i][j], dp[i-1][j]+map[i][j]);
            }

            for (int j=0; j<M; j++) {
                dp[i][j] = Math.max(temp1[j], temp2[j]);
            }
        }
        bw.write(String.valueOf(dp[N-1][M-1]));
        bw.close();
    }
}
