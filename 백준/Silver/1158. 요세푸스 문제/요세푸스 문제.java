import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static int N, K, cnt, i;
	static Deque<Integer> deque;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		K = sc.nextInt();
		sb.append("<");
		
		deque = new ArrayDeque<Integer>();
		
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		while (!deque.isEmpty()) {
			cnt = 1;
			while (cnt < K) {
				deque.add(deque.pollFirst());
				cnt++;
			}
			sb.append(deque.pollFirst()).append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.print(sb.toString());
	}

}
