import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	static List<int[]> list, virus;
	static int N, M, map[][], num, res[], x, y, nx, ny, ans, tmp;
	static boolean visited[][], rv[];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		list = new ArrayList<>();
		virus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new int[] { i, j });
				} else if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}
		res = new int[3];
		rv = new boolean[list.size()];
		ans = Integer.MAX_VALUE;
		wall(0, 0);
		System.out.println(list.size()-ans-3);
	}

	public static void wall(int at, int cnt) {
		if (cnt == 3) {
			// System.out.println(Arrays.toString(res));
			visited = new boolean[N][M];

			for (int r : res)
				map[list.get(r)[0]][list.get(r)[1]] = 1;

			bfs();
			for (int r : res)
				map[list.get(r)[0]][list.get(r)[1]] = 0;

			return;
		}

		for (int i = at; i < list.size(); i++) {
			res[cnt] = i;
			wall(i + 1, cnt + 1);
		}
	}

	public static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		tmp = 0;
		for (int[] v : virus) {
			int i = v[0]; int j = v[1];
			visited[i][j] = true;
			q.add(new int[] {i, j});
			while (!q.isEmpty()) {
				x = q.peekFirst()[0];
				y = q.peekFirst()[1];
				q.pollFirst();
				for (int d = 0; d < 4; d++) {
					nx = x + dx[d];
					ny = y + dy[d];
					if (0 <= nx && nx < N && 0 <= ny && ny < M) {
						if (map[nx][ny] == 0 && !visited[nx][ny]) {
							tmp++;
							visited[nx][ny] = true;
							q.add(new int[] {nx, ny});
						}
					}
				}
			}

		}
		ans = Math.min(ans, tmp);
	}
}
