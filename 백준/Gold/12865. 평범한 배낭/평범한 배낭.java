

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K, W[], V[], dp[][], w, v; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());  // 물건의 개수
		K = Integer.parseInt(st.nextToken());  // 물건의 가치
	
		W = new int[N+1];
		V = new int[N+1];
		int ans = Integer.MIN_VALUE;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				w = W[i];
				v = V[i];
				
				if (w > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(v+dp[i-1][j-w], dp[i-1][j]);
				}
				
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
	}

}
