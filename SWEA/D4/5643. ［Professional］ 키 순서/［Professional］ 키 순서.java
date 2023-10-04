

import java.io.*;
import java.util.*;

public class Solution {

	static int N, M, map[][], ans, gcnt, lcnt, a, b, i;
	static boolean visited[];
	static Deque<Integer> q;
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			//st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			ans = 0;

			map = new int[N+1][N+1];

			for (i = 0; i < M; i++){
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}

			for (i = 1; i <= N; i++){
				gcnt = lcnt = 0;
				gcnt = gbfs(i, 0);
				lcnt = lbfs(i, 0);
				if (gcnt + lcnt == N-1) ans++;
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	public static int gbfs(int v, int cnt){  // 큰 친구
		visited = new boolean[N+1];
		q = new ArrayDeque<>();
		q.add(v);
		visited[v] = true;

		while (!q.isEmpty()){
			int s = q.pollFirst();
			for (int i = 1; i <= N; i++){
				if (map[s][i] == 1 && !visited[i]){
					q.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static int lbfs(int v, int cnt){  // 작은 친구
		visited = new boolean[N+1];
		q = new ArrayDeque<>();
		q.add(v);
		visited[v] = true;

		while (!q.isEmpty()){
			int s = q.pollFirst();
			for (int i = 1; i <= N; i++){
				if (map[i][s] == 1 && !visited[i]){
					q.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
