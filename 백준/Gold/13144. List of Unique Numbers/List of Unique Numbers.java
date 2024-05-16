import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[] count = new boolean[100001];
		Long ans = 0L;

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

		for (int left=0, right=-1; left < N; left++) {
			while (right+1 < N && !count[arr[right+1]]) {
				right += 1;
				count[arr[right]] = true;
			}
			ans += right-left+1;
			count[arr[left]] = false;
		}
		System.out.println(ans);
	}
}