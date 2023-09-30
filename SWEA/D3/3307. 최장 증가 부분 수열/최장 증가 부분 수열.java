

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N, arr[], ans[], answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			ans = new int[N];
			ans[0] = 1;
			answer = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i < N; i++) {
				int tmp = 0;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i]) {
						tmp = Math.max(tmp, ans[j]);
					}
				}	
				ans[i] = tmp+1;
			}
			for (int i = 0; i < N; i++) {
				answer = Math.max(answer, ans[i]);
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
