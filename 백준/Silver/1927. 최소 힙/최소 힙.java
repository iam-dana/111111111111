import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new PriorityQueue<>();

		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (q.isEmpty()) sb.append(0).append("\n");  // q가 비어있으면 0
				else sb.append(q.poll()).append("\n");  // 비어있지 않으면 꺼냄
			} else {
				q.add(num);  // 0 이 아니면 q 에 값 추가
			}
		}
		System.out.println(sb);
	}
}
