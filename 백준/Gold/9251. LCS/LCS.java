import java.io.*;
import java.util.*;

public class Main {
    static String str1, str2;
    static Integer[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();

        dp = new Integer[str1.length()+1][str2.length()+1];

        System.out.println(LCS(str1.length(), str2.length()));
    }
    static int LCS(int x, int y) {
        if (x <= 0 || y <= 0) return 0;

        if (dp[x][y] == null) {
            dp[x][y] = 0;
            if (str1.charAt(x-1) == str2.charAt(y-1)) dp[x][y] = LCS(x-1, y-1)+1;
            else dp[x][y] = Math.max(LCS(x-1, y), LCS(x, y-1));
        }

        return dp[x][y];
    }
}
