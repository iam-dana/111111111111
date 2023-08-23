
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge> {  // edge 의 정보를 class 로 저장
		int from, to;
		long weight;

		public Edge(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {  // 가중치를 비교하여 저장
			return Long.compare(this.weight, o.weight);
		}
	}

	static int N;
	static ArrayList<Edge> edgeList;
	static int[] parents;
	static long[] x, y;
	static double E;
	static int count;
	static int[] res;
	static long cost;

	private static void make() {  
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;   // 자신이 대표자
		}
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;  // 자신이 대표자면 반환
		return parents[a] = find(parents[a]);  // path 압축
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) return false;   // cycle 발생
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			x = new long[N];
			y = new long[N];
			
			
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			edgeList = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					long dX = Math.abs(x[i]-x[j]);
					long dY = Math.abs(y[i]-y[j]);
					edgeList.add(new Edge(i, j, dX*dX+dY*dY));
				}
			}
			
			Collections.sort(edgeList);   // 간선 리스트를 가중치를 기준으로 오름차순 정렬
			
			make();  // N 개만큼 make set 작업
					
			cost = 0;  // 총 비용
			count = 0; // 연결된 간선 개수
			
			for (Edge edge: edgeList) {  
				if (union(edge.from, edge.to)) {  // 비용이 작은 간선 순으로 꺼내서 처리 
					cost += edge.weight;  // union 성공한다면 비용 담아줌
					if(++count == N-1) break;
				}
			}
			sb.append("#").append(t).append(" ").append(Math.round(cost*E)).append("\n");
		}
		System.out.println(sb);
	}

}
