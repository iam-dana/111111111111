import java.io.*;
import java.util.*;

public class Main {

	static int N, M, D, tmpAns, enemy = 0, ans = 0;
	static int[] res;
	static int[][] board, copyBoard;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 행의 N, 열의 수 M, 궁수의 공격 거리 D
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) enemy += 1; // 적의 개수
			}
		}

		res = new int[3];
		dfs(0, 0);
		System.out.println(ans);
	}

	static void dfs(int at, int depth) {
		if (depth == 3) {
			// System.out.println(Arrays.toString(res));
			defense();
			return;
		}
		for (int i = at; i < M; i++) {
			res[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}

	static void defense() {
		int nowEnemy = enemy;
		copyBoard = new int[N][M];
		for (int i = 0; i < N; i++) {
			copyBoard[i] = board[i].clone();
		}
		tmpAns = 0;
		int[][] target = new int[3][2];
		for (int i = 0; i <= N; i++) {
			if (nowEnemy == 0)
				break; // 적이 사라지면 게임 종료
			for (int j=0; j<3; j++) {
				int r = res[j];
				target[j] = findEnemy(r);
			}
			for (int[] t : target) {
				if (t[0] == -1 || t[1] == -1) continue;
				if (copyBoard[t[0]][t[1]] == 0) continue;
				if (copyBoard[t[0]][t[1]] == 1){
					copyBoard[t[0]][t[1]] = 0;
					tmpAns += 1;
				}
			}
			move();
		}
		ans = Math.max(ans, tmpAns);
	}

	static int[] findEnemy(int r) {
		int minDist = Integer.MAX_VALUE;
		int x = -1;
		int y = -1;
		for (int j=0; j<M; j++){
			for (int i=N-1; i>=0; i--) {
				if (copyBoard[i][j]==1 && (Math.abs(N-i) + Math.abs(r-j)) < minDist && ((Math.abs(N-i) + Math.abs(r-j)) <= D)){
					x = i;
					y = j;
					minDist = Math.abs(N-i) + Math.abs(r-j);
				}
			}
		}
		return new int[]{x, y};
	}
	static void move() {
		for (int i = N - 1; i >= 1; i--) {
			for (int j = 0; j < M; j++) {
				copyBoard[i][j] = copyBoard[i - 1][j];
			}
		}
		copyBoard[0] = new int[M];
	}
}
