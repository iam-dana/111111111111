

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int a, b, cnt, N, M;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];  // 인접리스트 
		visited = new boolean[N]; // 방문
		
		for (int i = 0; i < N; i++){
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);  // 인접리스트 생성
			list[b].add(a);
		}
		
		cnt = 0;  
		
		for (int i = 0; i < N; i++) {
			if(cnt == 0) {
				dfs(i, 1);
			}	
		}
		
		System.out.println(cnt);
	}
	
	public static void dfs(int v, int depth) {
		if(depth == 5) {  // 깊이가 5가 되면 정답 반환
			cnt = 1;
			return;
		}
		visited[v] = true;
		for (int i = 0; i < list[v].size(); i++) {  // 그 정점의 사이즈만큼 순회
			int next = list[v].get(i);  // 다음 노드
			if (!visited[next]) {  // 방문한 적이 없다면 
				dfs(next, depth+1);  // dfs
			}
		}
		visited[v] = false;  // depth가 5가 될 때까지 재귀 호출을 위함
	}
}





