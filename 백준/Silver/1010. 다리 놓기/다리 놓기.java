

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
//		int[][] dp = new int[31][31];
//		dp[1][0] = dp[1][1] = 1;
//		
//		for (int i = 2; i <= 30; i++) {
//			dp[i][0] = 1;
//			for (int j = 1; j <= i; j++) {
//				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
//			}
//		}

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			dp = new int[M+1][N+1];
			dp[1][0] = dp[1][1] = 1;
			
			for (int m = 2; m <= M; m++) {
				dp[m][0] = 1;
				for (int n = 1; n <= N; n++) {
					dp[m][n] = dp[m-1][n-1] + dp[m-1][n];
				}
			}
			
			System.out.println(dp[M][N]);
		}
	}

}
