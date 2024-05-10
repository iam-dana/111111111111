import java.io.*;
import java.util.*;

public class Main {
	static int N, a, b, num, minNum=6, count=0;
	static int[] ans;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		ans = new int[N+1];
		map = new int[N+1][N+1];

		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (i != j) map[i][j] = 100000;
			}
		}

		while (true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1) break;
			map[a][b] = map[b][a] = 1;
		}

		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		for (int i=1; i<=N; i++) {
			num = 0;
			for (int j=1; j<=N; j++) {
				if (map[i][j] != 100000) {
					num = Math.max(num, map[i][j]);
				}
			}
			ans[i] = num;
			minNum = Math.min(minNum, num);
		}


		for (int i=1; i<=N; i++) {
			if (ans[i] == minNum) {
				count += 1;
				sb.append(i).append(" ");
			}
		}
		System.out.println(minNum+" "+count);
		System.out.println(sb);
	}

}
