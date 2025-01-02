import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        int max = Integer.MIN_VALUE;

        for (int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());

        for (int i=1; i<=N; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(N-max);
    }
}
