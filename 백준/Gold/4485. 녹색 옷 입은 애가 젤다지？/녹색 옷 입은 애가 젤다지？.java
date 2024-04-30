import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {

		int x;
		int y;
		int cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static int bfs() {
		Queue<Node> q = new PriorityQueue<>();
		rupee = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				rupee[i][j] = Integer.MAX_VALUE;
			}
		}
		rupee[0][0] = cave[0][0];
		q.add(new Node(0, 0, cave[0][0]));

		while (!q.isEmpty()) {
			Node now = q.poll();
			x = now.x;
			y = now.y;
			cost = now.cost;
			if (x==N-1 && y==N-1) return cost;

			for (int i = 0; i < 4; i++){
				nx = x+dx[i];
				ny = y+dy[i];
				if (0<=nx && nx <N && 0 <= ny && ny<N) {
					if (cave[nx][ny]+cost < rupee[nx][ny]) {
						rupee[nx][ny] = cave[nx][ny]+cost;
						q.add(new Node(nx, ny, cave[nx][ny]+cost));
					}
				}
			}
		}
		return -1;
	}

	static int N, ans, x, y, nx, ny, cost, index;
	static int[][] cave, rupee;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String line;
		index = 1;

		while (!(line=br.readLine()).equals("0")) {
			N = Integer.parseInt(line);
			cave = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = bfs();
			sb.append("Problem ").append(index).append(": ").append(cost).append("\n");
			index+=1;
		}
		System.out.print(sb);
	}
}
