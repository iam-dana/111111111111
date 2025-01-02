import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        Deque<Integer> q = new ArrayDeque<>();

        for (int i=0; i<N; i++) {
            int now = input.charAt(i)-'0';
            while (K > 0 && !q.isEmpty() && q.peekLast() < now) {
                q.pollLast();
                K--;
            }
            q.add(now);
        }
        while (q.size() > K) {
            sb.append(q.pollFirst());
        }
        System.out.println(sb);
    }
}
