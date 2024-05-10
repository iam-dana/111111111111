import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][N+1];

		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (i != j) map[i][j] = 1000000;
			}
		}

		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}

		for (int k=1; k<=N; k++){
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		int tmp;
		int ans = 0;
		int bacon = Integer.MAX_VALUE;

		for (int i=1; i<=N; i++) {
			tmp = 0;
			for (int j=1; j<=N; j++) {
				tmp += map[i][j];
			}
			if (tmp < bacon) {
				ans = i;
				bacon = tmp;
			}
		}
		System.out.println(ans);
	}
}
