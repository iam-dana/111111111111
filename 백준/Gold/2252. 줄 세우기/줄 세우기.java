

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		int[] indegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			list[A].add(B);
			indegree[B]++;
		}

		Deque<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int current = q.poll();
			sb.append(current).append(" ");
			
			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				
				if (--indegree[next] == 0) {
					q.offer(next);
				}
			}	
		}
		System.out.println(sb);
	}

}
