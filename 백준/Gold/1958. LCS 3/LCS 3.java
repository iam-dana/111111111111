import java.io.*;
import java.util.*;

public class Main {
    static String str1, str2, str3;
    static char s1, s2, s3;
    static int N, M, K;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
        str3 = br.readLine();

        N = str1.length();
        M = str2.length();
        K = str3.length();

        System.out.println(LCS3());
    }

    static int LCS3() {
        dp = new int[N + 1][M + 1][K + 1];
        for (int i=1; i<=N; i++) {
            s1 = str1.charAt(i-1);
            for (int j=1; j<=M; j++) {
                s2 = str2.charAt(j-1);
                for (int k=1; k<=K; k++) {
                    s3 = str3.charAt(k-1);
                        if (s1 == s2 && s2 == s3) {
                            dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                        } else {
                            dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i][j-1][k]);
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k-1]);
                        }
                    }
                }
            }
        return dp[N][M][K];
    }
}
