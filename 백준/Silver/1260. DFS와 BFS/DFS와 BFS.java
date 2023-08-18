

import java.util.*;
import java.io.*;

public class Main {
	static int visit[];
	static int map[][];
	static int n;
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		visit = new int[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// System.out.println(x + " " + y);
			map[x][y] = 1;
			map[y][x] = 1;
		}
		dfs(v);
		System.out.println();
		visit = new int[n+1];
		bfs(v);
		
	}
	public static void dfs(int v) {
		visit[v] = 1;
		System.out.print(v + " ");
		
		for (int j = 1; j <= n; j++) {
			if (visit[j] == 0 && map[v][j] == 1) {
				dfs(j);
			}
		}
		
	}
	
	public static void bfs(int v) {
		visit[v] = 1;
		System.out.print(v + " ");
		
		Deque<Integer> deque = new ArrayDeque<>();
		deque.add(v);
		
		while (deque.isEmpty() == false) {
			int s = deque.pollFirst();
			for(int j = 1; j <= n; j++) {
				if (visit[j] == 0 && map[s][j] == 1) {
					deque.add(j);
					visit[j] = 1;
					System.out.print(j + " ");
				}
			}
		}
	}
}
