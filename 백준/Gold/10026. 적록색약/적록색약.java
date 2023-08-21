

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	static String[][] map, map2;
	static String[] str;
	static boolean[][] visited, visited2;
	static int N, tx, ty, nx, ny, ans = 0, ans2 = 0;
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		map2 = new String[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = str[j];
				if (str[j].equals("R") || str[j].equals("G")) {
					map2[i][j] = "A";
				}
				else {
					map2[i][j] = str[j];
				}
			}
		}
		
		ans = bfs(map, visited, ans); 
		ans2 = bfs(map2, visited2, ans2);
		System.out.println(ans + " " + ans2);
		
		
	}

	public static int bfs(String[][] map, boolean[][] visited, int ans) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (!visited[x][y]) {
					String tmp = map[x][y];
					ArrayDeque<int[]> q = new ArrayDeque<int[]>();
					q.add(new int[] { x, y });
					visited[x][y] = true;
					ans++;

					while (!q.isEmpty()) {
						tx = q.peekFirst()[0]; ty = q.peekFirst()[1];
						q.pollFirst();
						
						for(int i = 0; i < 4; i++) {
							nx = tx + dx[i]; ny = ty + dy[i];
							if (0 <= nx && nx < N && 0 <= ny && ny < N) {
								if (map[nx][ny].equals(tmp) && !visited[nx][ny]) {
									q.add(new int[] {nx, ny});
									visited[nx][ny] = true;
								}
							}
						}
					}
				}

			}
		}
		return ans;
	}
	
	
}
