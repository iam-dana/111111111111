import java.io.*;
import java.util.*;

public class Main {

	static int N, M, count=0;
	static Map<String, Integer> keyword;
	static String[] used;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		keyword = new HashMap<>();
		for (int i = 0; i < N; i++) {
			keyword.put(br.readLine(), 1);
			count += 1;
		}

		for (int i = 0; i < M; i++) {
			used = br.readLine().split(",");
			for (String word : used) {
				if (keyword.containsKey(word) && keyword.get(word) == 1) {
					keyword.put(word, 0);
					count -= 1;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}
