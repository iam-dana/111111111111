

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, i, j, T = 10, answer;
	static String[] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			answer = 1;
			for (i = 0; i < N; i++) {
				node = br.readLine().split(" ");

				if (node.length < 4 && node[1].charAt(0) < '0' || node.length == 4 && node[1].charAt(0) >= '0') {
					for (j = i+1; j < N; j++) {
						br.readLine();
					}
					answer = 0;
					break;
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
