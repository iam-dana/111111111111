import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// 절대값 기준으로 값이 작다면 앞으로 보낸다.
				if(Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
					
				// 절대값이 같다면 음수를 앞으로 보냄.
				}else if (Math.abs(o1) == Math.abs(o2)) {
					return o1-o2;
				}
				else
					return -1;
			}
		});
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(q.isEmpty()) sb.append(0).append("\n");
				else sb.append(q.poll()).append("\n");
			}
			else {
				q.offer(x);
			}
		}
		System.out.println(sb);
	}

}
