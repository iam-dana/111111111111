

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];
		int[][] cost = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cost[0][0] = map[0][0];
		cost[0][1] = map[0][1];
		cost[0][2] = map[0][2];
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Math.min(cost[i-1][(j+1)%3]+map[i][j], cost[i-1][(j+2)%3]+map[i][j]);
			}
		}
		
		int ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			ans = Math.min(ans, cost[N-1][i]);
		}
		System.out.println(ans);
	}

}
