

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, ans;
	static String[] str;
	static String[][] map;
	static int dx[] = { -1, 0, 1 };
	static int dy[] = { 1, 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		ans = 0;

		for (int r = 0; r < R; r++) {
			str = br.readLine().split("");
			for (int c = 0; c < C; c++) {
				map[r][c] = str[c];
			}
		}

		for (int i = 0; i < R; i++) {
			if(check(i, 0)) ans++;
		}

		System.out.println(ans);
	}

	public static boolean check(int x, int y) {
		map[x][y] = "-";

		// 원웅이네 빵집에 도착했을 때
		if (y == C - 1) {
			return true;
		}

		// 오른쪽 위
		if (x > 0 && map[x - 1][y + 1].equals(".")) {
			if(check(x-1, y+1)) return true;
		}
		
		// 오른쪽
		if (map[x][y+1].equals(".")) {
			if(check(x, y+1)) return true;
		}
		
		// 오른쪽 아래
		if (x < R-1 && map[x+1][y+1].equals(".")) {
			if(check(x+1, y+1)) return true;
		}
		
		return false;
	}

}
