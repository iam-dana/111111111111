import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        int[] tmp = new int[N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                tmp[j] = Integer.parseInt(st.nextToken());
                if (pq.size() < N) pq.offer(tmp[j]);
                else {
                    pq.offer(tmp[j]);
                    pq.poll();
                }
            }
        }
        System.out.println(pq.poll());
    }
}
