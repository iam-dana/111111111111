
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static Deque<Integer> deque;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		deque = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		
		while (deque.size() > 1) {
			deque.pollFirst();
			deque.add(deque.pollFirst());
		}
		System.out.println(deque.pop());
	}

}
