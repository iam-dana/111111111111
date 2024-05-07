import java.io.*;
import java.util.*;

public class Main {
	static int N, M, L, left, right, mid, tmpDist, count, ans;
	static int[] road;
	static Set<Integer> installed, tmpSet;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		road = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(road);
		
		left = 1;
		right = L;

		while (left <= right) {
			mid = (left+right)/2;
			count = 0;

			for (int i=1; i<=N; i++) {
				tmpDist = road[i]-road[i-1];
				count += tmpDist/mid;
				if (tmpDist % mid == 0) count -= 1; // 이미 휴게소가 세워진 곳
			}
			tmpDist = L-road[N];
			count += tmpDist/mid;
			if (tmpDist % mid == 0) count -= 1; // 이미 휴게소가 세워진 곳


			if (count <= M) {
				ans = mid;
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}

		System.out.println(ans);
	}
}
