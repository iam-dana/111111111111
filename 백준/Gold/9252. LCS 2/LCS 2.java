import java.io.*;
import java.util.*;

public class Main {
    static String str1, str2;
    static int n, m, count;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        str1 = br.readLine();
        str2 = br.readLine();
        n = str1.length();
        m = str2.length();

        dp = new int[n + 1][m + 1];
        count = LCS();

        if (count > 0) {
            while (n > 0 && m > 0) {
                if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
                    sb.insert(0, str1.charAt(n-1));
                    n--;
                    m--;
                } else if (dp[n][m] == dp[n - 1][m]) {
                    n--;
                } else if (dp[n][m] == dp[n][m - 1]) {
                    m--;
                }
            }
        }
        bw.write(count+"\n"+sb);
        bw.close();
    }

    static int LCS() {
        for (int i=1; i<=n; i++) {
            char s1 = str1.charAt(i-1);
            for (int j=1; j<=m; j++) {
                char s2 = str2.charAt(j-1);
                if (s1 == s2) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
