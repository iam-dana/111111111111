import java.io.*;
import java.util.*;

public class Main {

	static int N, M, x, y, nx, ny, ans, fuel;
	static int[][] map;
	static int[] dx = {1, 1, 1};
	static int[] dy = {-1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;

		map = new int[N][M];
		for(int i=0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (y=0; y<M; y++){
			x = 0;
			fuel = map[x][y];
			for (int i=0; i<3; i++){
				search(x, y, i, fuel);
			}
		}
		System.out.println(ans);
	}
	static void search(int x, int y, int prev, int fuel) {
		if (x==N-1) {
			ans = Math.min(fuel, ans);
			return;
		}

		for (int j=0; j<3; j++){
			if (prev==j) continue;
			nx = x+dx[j];
			ny = y+dy[j];
			if (ny < 0 || ny >= M) continue;
			search(nx, ny, j, fuel+map[nx][ny]);
		}
	}
}
