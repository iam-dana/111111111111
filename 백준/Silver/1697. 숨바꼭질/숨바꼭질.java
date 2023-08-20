

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static int N, K, ans, x, nx, s;
	static int[] visited;
	static Deque<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		visited = new int[100001];
		
		bfs();
		System.out.println(visited[K]);
		
	}

	public static void bfs() {
		q = new ArrayDeque<Integer>();
		visited[N] = 0;
		q.add(N);
		
		while (!q.isEmpty()) {
			x = q.pollFirst();
			if(x == K) {
				return;
			}
			
			for(int i = 0; i < 3; i++) {
				if (i == 0) {
					nx = x-1;
					if (0 <= nx && nx <= 100000 && visited[nx] == 0) {
						visited[nx] = visited[x] + 1;
						q.add(nx);
					}
				}
				
				if (i == 1) {
					nx = x+1;
					if (0 <= nx && nx <= 100000 && visited[nx] == 0) {
						visited[nx] = visited[x] + 1;
						q.add(nx);
					}
				}
				
				if (i == 2) {
					nx = x*2;
					if (0 <= nx && nx <= 100000 && visited[nx] == 0) {
						visited[nx] = visited[x] + 1;
						q.add(nx);
					}
				}
			}
		}
		

		
	}

}
