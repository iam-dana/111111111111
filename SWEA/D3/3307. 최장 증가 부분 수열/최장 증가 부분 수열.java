
import java.io.*;
import java.util.*;

public class Solution {

	static int N, a, answer, i, start, end, mid;
	static List<Integer> lis;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			lis = new ArrayList<>();
			answer = 0;

			st = new StringTokenizer(br.readLine());
			for (i = 0; i < N; i++) {
				a = Integer.parseInt(st.nextToken());
				if(i == 0) {
					lis.add(a);
					continue;
				}
				if (a > lis.get(lis.size()-1)) {
					lis.add(a);
				} else {
					start = 0;
					end = lis.size();
					
					while (start < end) {
						mid = (end+start)/2;
						
						if (a <= lis.get(mid)) {
							end = mid;
						} else {
							start = mid+1;
						}
					}
					lis.remove(end);
					lis.add(end, a);
				}
				
			}
			sb.append("#").append(t).append(" ").append(lis.size()).append("\n");
		}
		System.out.println(sb);
	}

}
