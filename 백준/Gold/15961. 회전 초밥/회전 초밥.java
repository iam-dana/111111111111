

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, d, k, c, ans, cnt;
	static int[] sushi;
	static int[] visited;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sushi = new int[N * 2];
		visited = new int[d+1];

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			sushi[i] = tmp;
			sushi[i + N] = tmp;
		}
		
		
		ans = Integer.MIN_VALUE;
		cnt = 0;

		for (int i = 0; i < k; i++) {
			
			visited[sushi[i]]++;
		}
		
		for (int i = 1; i <= d; i++) {
			if (visited[i] != 0) {
				cnt++;
			}
		}
		if (visited[c] == 0) {
			ans = Math.max(ans, cnt+1);
		}
		else {
			ans = Math.max(ans, cnt);
		}
		
		for (int i = k; i < N+k-1; i++) {
			//list.remove(Integer.valueOf(sushi[i-k]));
			//list.add(sushi[i]);
//			if (visited[sushi[i-k]] > 0) {
//				visited[sushi[i-k]]--;
//				cnt--;
//			}
//			visited[sushi[i]]++;
//			if (visited[sushi[i]] == 1) cnt++;
//			if (visited[c] == 0) cnt++;
//			ans = Math.max(cnt, ans);
			visited[sushi[i-k]]--;
			if (visited[sushi[i-k]] == 0) cnt--;
			visited[sushi[i]]++;
			if (visited[sushi[i]] == 1) cnt++;
			if (visited[c] == 0) {
				ans = Math.max(ans, cnt+1);
			}
			else {
				ans = Math.max(ans, cnt);
			}
		}

		System.out.println(ans);
	}
}
