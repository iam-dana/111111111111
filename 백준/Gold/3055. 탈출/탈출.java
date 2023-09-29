

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int R, C, sX, sY, nx, ny, x, y, cnt, waterTmp, waterAns, sAns, ans = Integer.MAX_VALUE;
	static boolean visited[][];
	static String str[], map[][];
	static List<int[]> water, tmp, destiny;
	static Deque<int[]> q;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static int bfs(int i, int j, int[] dest) {
		cnt = 0;
		visited = new boolean[R][C];
		q = new ArrayDeque<>();
		q.add(new int[] { i, j, 0 });

		while (!q.isEmpty()) {
			x = q.peekFirst()[0];
			y = q.peekFirst()[1];
			cnt = q.peekFirst()[2];
			if (x == dest[0] && y == dest[1]) {
				return cnt + 1;
			}
			q.pollFirst();
			for (int d = 0; d < 4; d++) {
				nx = x + dx[d];
				ny = y + dy[d];
				if (0 <= nx && nx < R && 0 <= ny && ny < C) {
					if (map[nx][ny].equals(".") && !visited[nx][ny]) {
						q.add(new int[] { nx, ny, cnt + 1 });
						visited[nx][ny] = true;
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		water = new ArrayList<>();
		destiny = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = str[j];
				if (map[i][j].equals("*")) {
					water.add(new int[] { i, j });
				} else if (map[i][j].equals("S")) {
					sX = i;
					sY = j;
				} else if (map[i][j].equals("*")) {
					water.add(new int[] { i, j });
				} else if (map[i][j].equals("D")) {
					for (int d = 0; d < 4; d++) {
						nx = i + dx[d];
						ny = j + dy[d];
						if (0 <= nx && nx < R && 0 <= ny && ny < C) {
							destiny.add(new int[] { nx, ny });
						}
					}
				}
			}
		}

		for (int[] d : destiny) {
			boolean check = false;
			sAns = bfs(sX, sY, d);
			waterAns = Integer.MAX_VALUE;
			for (int[] w : water) {
				waterTmp = bfs(w[0], w[1], d);
				waterAns = Math.min(waterAns, waterTmp);
			}
			if (sAns < waterAns) {
				ans = Math.min(sAns, ans);
			} 
		}
		
		if (ans==Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(ans);
		}
	}

}
