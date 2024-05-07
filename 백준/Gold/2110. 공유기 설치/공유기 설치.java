import java.io.*;
import java.util.*;

public class Main {
	static int N, C, left, right, mid, start, count, distance, ans;
	static int[] home, res;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		home = new int[N];
		res = new int[C];

		for (int i=0; i<N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);

		left = 0;
		right = home[N-1]-home[0]; // 최대 거리

		while (left <= right) {
			mid = (right+left)/2;
			start = home[0];
			count = 1;

			for (int i=0; i<N; i++) {
				distance = home[i]-start;
				if (distance >= mid) {
					start = home[i];
					count += 1;
				}
			}
			if (count >= C) {
				ans = mid;
				left = mid+1;

			} else {
				right = mid-1;
			}
		}
		System.out.println(ans);
	}

}
